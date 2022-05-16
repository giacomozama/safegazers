package test.safegazers.sdk.domain.service

import test.safegazers.sdk.security.state.SecurityStateProvider

interface SafeStargazersServiceFactory {

    fun create(securityStateProvider: SecurityStateProvider): SafeStargazersService
}