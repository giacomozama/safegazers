package test.safegazers.sdk.domain.service

import android.content.Context
import androidx.paging.Pager
import test.safegazers.sdk.domain.entities.Stargazer

interface SafeStargazersService {

    fun getStargazersPager(context: Context, owner: String, repo: String): Result<Pager<Int, Stargazer>>
}