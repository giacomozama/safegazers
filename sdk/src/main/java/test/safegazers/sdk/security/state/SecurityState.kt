package test.safegazers.sdk.security.state

sealed interface SecurityState {
    object Secure : SecurityState
    class Unsecure(val reason: SecurityException) : SecurityState
    class Error(val error: Throwable) : SecurityState
}