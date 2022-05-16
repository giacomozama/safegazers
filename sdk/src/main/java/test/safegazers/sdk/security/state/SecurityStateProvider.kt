package test.safegazers.sdk.security.state

import android.content.Context

interface SecurityStateProvider {

    fun getSecurityState(context: Context): SecurityState
}