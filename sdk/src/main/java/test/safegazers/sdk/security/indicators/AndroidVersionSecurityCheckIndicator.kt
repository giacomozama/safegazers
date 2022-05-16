package test.safegazers.sdk.security.indicators

import android.content.Context
import android.os.Build
import test.safegazers.sdk.security.state.SecurityState

internal object AndroidVersionSecurityCheckIndicator : SecurityCheckIndicator {

    override fun createSecurityException() = SecurityException("Android version is lower than 12")

    /**
     * Checks whether we are on Android 12+
     * */
    override fun evaluate(context: Context): SecurityState =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            SecurityState.Secure
        } else {
            SecurityState.Unsecure(createSecurityException())
        }
}