package test.safegazers.sdk.security.state

import test.safegazers.sdk.security.SecurityCheckSpec

interface SecurityStateProviderFactory {

    fun create(
        securityCheckSpec: SecurityCheckSpec,
        isCached: Boolean
    ): SecurityStateProvider
}