package test.safegazers.sdk.security.indicators

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import test.safegazers.sdk.security.state.SecurityState
import java.io.IOException


internal object EmulationSecurityCheckIndicator : SecurityCheckIndicator {

    private fun getSystemProperty(propertyName: String, default: String = ""): String {
        try {
            @SuppressLint("PrivateApi")
            val clazz = Class.forName("android.os.SystemProperties")
            val getPropMethod = clazz.getMethod("get", String::class.java, String::class.java)
            return getPropMethod.invoke(null, propertyName, default) as String? ?: default
        } catch (e: Exception) {
            var process: Process? = null
            try {
                process = Runtime.getRuntime().exec("getprop \"$propertyName\" \"$default\"")
                return process.inputStream.reader().buffered().use { it.readLine() }
            } catch (e: IOException) {
                // ignored
            } finally {
                process?.destroy()
            }
        }
        return default
    }

    override fun createSecurityException() = SecurityException("Android device is emulated")

    /**
     * Checks whether the device is emulated.
     *
     * This is implemented with code from a StackOverflow thread and I seriously question its accuracy.
     * */
    override fun evaluate(context: Context) = try {
        val isEmulated = (
            Build.FINGERPRINT.startsWith("google/sdk_gphone_")
                && Build.FINGERPRINT.endsWith(":user/release-keys")
                && Build.MANUFACTURER == "Google"
                && Build.PRODUCT.startsWith("sdk_gphone_")
                && Build.BRAND == "google"
                && Build.MODEL.startsWith("sdk_gphone_")
            )
            || Build.FINGERPRINT.startsWith("generic")
            || Build.FINGERPRINT.startsWith("unknown")
            || Build.MODEL.contains("google_sdk")
            || Build.MODEL.contains("Emulator")
            || Build.MODEL.contains("Android SDK built for x86")
            || "QC_Reference_Phone" == Build.BOARD && !"Xiaomi".equals(Build.MANUFACTURER, ignoreCase = true)
            || Build.MANUFACTURER.contains("Genymotion")
            || Build.HOST.startsWith("Build")
            || Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")
            || Build.PRODUCT == "google_sdk"
            || getSystemProperty("ro.kernel.qemu") == "1"

        if (!isEmulated) {
            SecurityState.Secure
        } else {
            SecurityState.Unsecure(createSecurityException())
        }
    } catch (e: Throwable) {
        SecurityState.Error(e)
    }
}