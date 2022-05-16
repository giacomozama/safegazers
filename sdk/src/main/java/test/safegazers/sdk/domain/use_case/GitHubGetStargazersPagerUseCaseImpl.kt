package test.safegazers.sdk.domain.use_case

import test.safegazers.sdk.data.repository.GitHubRepository
import javax.inject.Inject

internal class GitHubGetStargazersPagerUseCaseImpl @Inject internal constructor(
    private val gitHubRepository: GitHubRepository
) : GitHubGetStargazersPagerUseCase {

    override fun invoke(owner: String, repo: String) = gitHubRepository.getStargazersPager(owner, repo)
}

