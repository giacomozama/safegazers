package test.safegazers.sdk.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import test.safegazers.sdk.data.paging.StargazersPagingSourceFactory
import test.safegazers.sdk.domain.entities.Stargazer
import javax.inject.Inject

internal class GitHubRepository @Inject constructor(
    private val stargazersPagingSourceFactory: StargazersPagingSourceFactory
) {

    fun getStargazersPager(owner: String, repo: String): Pager<Int, Stargazer> = Pager(
        config = PagingConfig(pageSize = 100)
    ) {
        stargazersPagingSourceFactory.create(owner, repo)
    }
}