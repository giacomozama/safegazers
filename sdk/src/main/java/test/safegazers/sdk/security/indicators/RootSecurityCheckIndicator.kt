package test.safegazers.sdk.security.indicators

import android.content.Context
import com.scottyab.rootbeer.RootBeer
import test.safegazers.sdk.security.state.SecurityState

internal object RootSecurityCheckIndicator : SecurityCheckIndicator {

    override fun createSecurityException() = SecurityException("Device is rooted")

    /**
     * Attempts to check whether the device is rooted
     * */
    override fun evaluate(context: Context) = try {
        if (!RootBeer(context).isRooted) SecurityState.Secure else SecurityState.Unsecure(createSecurityException())
    } catch (e: Exception) {
        SecurityState.Error(e)
    }
}