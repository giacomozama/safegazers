package test.safegazers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import test.safegazers.sdk.SafegazersSdk
import test.safegazers.sdk.domain.service.SafeStargazersService
import test.safegazers.sdk.domain.service.SafeStargazersServiceFactory
import test.safegazers.sdk.security.configureSecurityCheck
import test.safegazers.sdk.security.state.SecurityStateProviderFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SafegazersSdkModule {

    /*@Provides
    fun provideSafeStargazersService(): SafeStargazersService = SafegazersSdk.DefaultSafeStargazersService*/

    @Provides
    fun provideSafeStargazersServiceFactory(): SafeStargazersServiceFactory = SafegazersSdk.SafeStargazersServiceFactory

    @Provides
    fun provideSecurityStateProviderFactory(): SecurityStateProviderFactory = SafegazersSdk.SecurityStateProviderFactory

    @Provides
    @Singleton
    fun provideSafeStargazersService(
        safeStargazersServiceFactory: SafeStargazersServiceFactory,
        securityStateProviderFactory: SecurityStateProviderFactory
    ): SafeStargazersService {
        return safeStargazersServiceFactory.create(
            securityStateProviderFactory.create(
                configureSecurityCheck {
                    skipAndroidVersionCheck()
                },
                true
            )
        )
    }
}