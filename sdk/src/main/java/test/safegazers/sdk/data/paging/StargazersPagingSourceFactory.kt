package test.safegazers.sdk.data.paging

import androidx.paging.PagingSource
import test.safegazers.sdk.domain.entities.Stargazer


interface StargazersPagingSourceFactory {

    fun create(owner: String, repo: String): PagingSource<Int, Stargazer>
}