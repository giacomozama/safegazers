package test.safegazers.sdk.security.indicators

import android.content.Context
import test.safegazers.sdk.security.state.SecurityState

internal object PackageNameSecurityCheckIndicator : SecurityCheckIndicator {

    override fun createSecurityException() = SecurityException("Package name is too long")

    /**
     * Checks whether the current application's package name is too long
     * */
    override fun evaluate(context: Context) = if (context.packageName.length <= PackageNameMaxLength) {
        SecurityState.Secure
    } else {
        SecurityState.Unsecure(createSecurityException())
    }

    private const val PackageNameMaxLength = 20
}