package test.safegazers.sdk.domain.service

import test.safegazers.sdk.domain.use_case.GitHubGetStargazersPagerUseCase
import test.safegazers.sdk.security.state.SecurityStateProvider

internal class SafeStargazersServiceFactoryImpl(
    private val gitHubGetStargazersPagerUseCase: GitHubGetStargazersPagerUseCase
) : SafeStargazersServiceFactory {

    override fun create(securityStateProvider: SecurityStateProvider): SafeStargazersService =
        SafeStargazersServiceImpl(securityStateProvider, gitHubGetStargazersPagerUseCase)
}