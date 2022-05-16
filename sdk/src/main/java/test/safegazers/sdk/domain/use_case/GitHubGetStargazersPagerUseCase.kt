package test.safegazers.sdk.domain.use_case

import androidx.paging.Pager
import test.safegazers.sdk.domain.entities.Stargazer

internal interface GitHubGetStargazersPagerUseCase {

    fun invoke(owner: String, repo: String): Pager<Int, Stargazer>
}