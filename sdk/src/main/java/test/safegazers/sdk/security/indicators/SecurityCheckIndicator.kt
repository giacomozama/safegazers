package test.safegazers.sdk.security.indicators

import android.content.Context
import test.safegazers.sdk.security.state.SecurityState

internal sealed interface SecurityCheckIndicator {

    fun createSecurityException(): SecurityException

    fun evaluate(context: Context): SecurityState
}