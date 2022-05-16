package test.safegazers.sdk.di

import dagger.Component
import test.safegazers.sdk.data.paging.PagingModule
import test.safegazers.sdk.data.source.remote.RemoteDataSourceModule
import test.safegazers.sdk.domain.service.SafeStargazersService
import test.safegazers.sdk.domain.service.SafeStargazersServiceFactory
import test.safegazers.sdk.domain.service.SafeStargazersServiceModule
import test.safegazers.sdk.domain.service.SdkDefaultSafegazersService
import test.safegazers.sdk.domain.use_case.UseCaseModule
import test.safegazers.sdk.security.state.SdkDefaultSecurityStateProvider
import test.safegazers.sdk.security.state.SecurityStateProvider
import test.safegazers.sdk.security.state.SecurityStateProviderFactory
import test.safegazers.sdk.security.state.SecurityStateProviderModule
import test.safegazers.sdk.utils.moshi.MoshiModule
import javax.inject.Singleton

@Component(
    modules = [
        RemoteDataSourceModule::class,
        PagingModule::class,
        SafeStargazersServiceModule::class,
        SecurityStateProviderModule::class,
        UseCaseModule::class,
        MoshiModule::class
    ]
)
@Singleton
internal interface SdkComponent {

    @SdkDefaultSafegazersService
    fun defaultSafeStargazersService(): SafeStargazersService

    @SdkDefaultSecurityStateProvider
    fun defaultSecurityStateProvider(): SecurityStateProvider

    fun safeStargazersServiceFactory(): SafeStargazersServiceFactory

    fun safeSecurityStateProviderFactory(): SecurityStateProviderFactory

    @Component.Factory
    interface Factory {

        fun create(): SdkComponent
    }
}