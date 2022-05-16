package test.safegazers.sdk.domain.service

import android.content.Context
import test.safegazers.sdk.domain.use_case.GitHubGetStargazersPagerUseCase
import test.safegazers.sdk.security.state.SecurityState
import test.safegazers.sdk.security.state.SecurityStateProvider

internal class SafeStargazersServiceImpl(
    private val securityStateProvider: SecurityStateProvider,
    private val gitHubGetStargazersPagerUseCase: GitHubGetStargazersPagerUseCase
) : SafeStargazersService {

    override fun getStargazersPager(context: Context, owner: String, repo: String) =
        when (val state = securityStateProvider.getSecurityState(context)) {
            SecurityState.Secure -> Result.success(gitHubGetStargazersPagerUseCase.invoke(owner, repo))
            is SecurityState.Error -> Result.failure(state.error)
            is SecurityState.Unsecure -> Result.failure(state.reason)
        }
}