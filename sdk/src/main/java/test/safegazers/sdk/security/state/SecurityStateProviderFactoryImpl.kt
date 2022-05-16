package test.safegazers.sdk.security.state

import test.safegazers.sdk.security.SecurityCheckSpec

internal class SecurityStateProviderFactoryImpl : SecurityStateProviderFactory {

    override fun create(securityCheckSpec: SecurityCheckSpec, isCached: Boolean): SecurityStateProvider =
        SecurityStateProviderImpl(securityCheckSpec, isCached)
}