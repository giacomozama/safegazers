package test.safegazers.sdk.security.state

import android.content.Context
import test.safegazers.sdk.security.SecurityCheckSpec
import test.safegazers.sdk.security.indicators.*

internal class SecurityStateProviderImpl(
    private val securityCheckSpec: SecurityCheckSpec,
    private var isCached: Boolean
) : SecurityStateProvider {

    private var result: SecurityState? = null

    private fun getCheckIndicatorsSequence() = sequence {
        if (!securityCheckSpec.isSkipEmulationCheck) {
            yield(EmulationSecurityCheckIndicator)
        }

        if (!securityCheckSpec.isSkipRootCheck) {
            yield(RootSecurityCheckIndicator)
        }

        if (!securityCheckSpec.isSkipPackageNameCheck) {
            yield(PackageNameSecurityCheckIndicator)
        }

        if (!securityCheckSpec.isSkipAndroidVersionCheck) {
            yield(AndroidVersionSecurityCheckIndicator)
        }

        if (!securityCheckSpec.isSkipReceiversInManifestCheck) {
            yield(ReceiversInManifestSecurityCheckIndicator)
        }
    }

    override fun getSecurityState(context: Context): SecurityState {
        if (isCached) result?.let { return it }
        val forgiveErrors = securityCheckSpec.isForgiveErrors
        val indicators = getCheckIndicatorsSequence()
        for (indicator in indicators) {
            when (val indicatorResult = indicator.evaluate(context)) {
                SecurityState.Secure -> {
                }
                is SecurityState.Unsecure -> {
                    return indicatorResult.also {
                        if (isCached) result = it
                    }
                }
                is SecurityState.Error -> {
                    if (!forgiveErrors) return indicatorResult.also {
                        if (isCached) result = it
                    }
                }
            }
        }
        return SecurityState.Secure.also {
            if (isCached) result = it
        }
    }
}