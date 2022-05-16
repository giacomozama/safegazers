package test.safegazers.sdk.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import test.safegazers.sdk.data.source.remote.GitHubRemoteDataSource
import test.safegazers.sdk.domain.entities.Stargazer
import test.safegazers.sdk.domain.service.StargazersException

internal class StargazersPagingSource(
    private val owner: String,
    private val repo: String,
    private val gitHubRemoteDataSource: GitHubRemoteDataSource
) : PagingSource<Int, Stargazer>() {

    override fun getRefreshKey(state: PagingState<Int, Stargazer>) = state.anchorPosition?.let {
        state.closestPageToPosition(it)?.prevKey?.plus(1)
            ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stargazer> {
        val page = params.key ?: 0
        return try {
            Log.d("StargazersPagingSource", "Loading page ${page + 1}")
            val response = gitHubRemoteDataSource.getStargazers(owner = owner, repo = repo, page = page + 1)
            if (!response.isSuccessful) {
                @Suppress("BlockingMethodInNonBlockingContext")
                LoadResult.Error(StargazersException(response.errorBody()?.string()))
            } else {
                val songs = response.body().orEmpty()
                LoadResult.Page(
                    data = songs,
                    prevKey = if (page > 0) page - 1 else null,
                    nextKey = if (songs.isEmpty()) null else page + 1
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}