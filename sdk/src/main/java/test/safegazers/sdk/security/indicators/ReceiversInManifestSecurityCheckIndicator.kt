package test.safegazers.sdk.security.indicators

import android.content.Context
import android.content.pm.PackageManager
import test.safegazers.sdk.security.state.SecurityState

internal object ReceiversInManifestSecurityCheckIndicator : SecurityCheckIndicator {

    override fun createSecurityException() = SecurityException("Receivers present in manifest")

    /**
     * Checks whether the current package has any receivers declared other than ProfileInstallReceiver
     * */
    override fun evaluate(context: Context): SecurityState {
        val hasReceivers = context.packageManager
            .getPackageInfo(context.packageName, PackageManager.GET_RECEIVERS)
            .receivers
            .any { !it.name.endsWith("ProfileInstallReceiver") }

        return if (!hasReceivers) SecurityState.Secure else SecurityState.Unsecure(createSecurityException())
    }
}