package test.safegazers.domain.use_case

import android.content.Context
import test.safegazers.sdk.domain.service.SafeStargazersService

class GetStargazersPagerUseCase(
    private val context: Context,
    private val safeStargazersService: SafeStargazersService
) {

    fun invoke(owner: String, repo: String) = safeStargazersService.getStargazersPager(context, owner, repo)
}