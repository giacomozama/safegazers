package test.safegazers.sdk.domain.use_case

import dagger.Binds
import dagger.Module

@Module
@Suppress("unused")
internal interface UseCaseModule {

    @Binds
    fun bindGitHubGetStargazersUseCase(
        gitHubGetStargazersUseCaseImpl: GitHubGetStargazersPagerUseCaseImpl
    ): GitHubGetStargazersPagerUseCase
}