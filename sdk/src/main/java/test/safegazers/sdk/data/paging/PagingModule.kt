package test.safegazers.sdk.data.paging

import dagger.Module
import dagger.Provides
import test.safegazers.sdk.data.source.remote.GitHubRemoteDataSource

@Module
internal class PagingModule {

    @Provides
    fun provideStargazersPagingSourceFactory(
        gitHubRemoteDataSource: GitHubRemoteDataSource
    ): StargazersPagingSourceFactory = StargazersPagingSourceFactoryImpl(gitHubRemoteDataSource)
}