package test.safegazers.sdk.domain.service

import dagger.Module
import dagger.Provides
import test.safegazers.sdk.domain.use_case.GitHubGetStargazersPagerUseCase
import test.safegazers.sdk.security.state.SdkDefaultSecurityStateProvider
import test.safegazers.sdk.security.state.SecurityStateProvider
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SdkDefaultSafegazersService

@Module
internal class SafeStargazersServiceModule {

    @Provides
    @SdkDefaultSafegazersService
    fun provideSafegazersService(
        @SdkDefaultSecurityStateProvider securityStateProvider: SecurityStateProvider,
        gitHubGetStargazersPagerUseCase: GitHubGetStargazersPagerUseCase
    ): SafeStargazersService = SafeStargazersServiceImpl(securityStateProvider, gitHubGetStargazersPagerUseCase)

    @Provides
    fun provideSafeStartfazersServiceFactory(
        gitHubGetStargazersPagerUseCase: GitHubGetStargazersPagerUseCase
    ): SafeStargazersServiceFactory = SafeStargazersServiceFactoryImpl(gitHubGetStargazersPagerUseCase)
}