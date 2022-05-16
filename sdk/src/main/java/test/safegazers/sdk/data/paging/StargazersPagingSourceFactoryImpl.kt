package test.safegazers.sdk.data.paging

import androidx.paging.PagingSource
import test.safegazers.sdk.data.source.remote.GitHubRemoteDataSource
import test.safegazers.sdk.domain.entities.Stargazer

internal class StargazersPagingSourceFactoryImpl(
    private val gitHubRemoteDataSource: GitHubRemoteDataSource
) : StargazersPagingSourceFactory {

    override fun create(owner: String, repo: String): PagingSource<Int, Stargazer> =
        StargazersPagingSource(owner, repo, gitHubRemoteDataSource)
}