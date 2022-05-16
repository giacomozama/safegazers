package test.safegazers.sdk.security.state

import dagger.Module
import dagger.Provides
import test.safegazers.sdk.security.SecurityCheckSpec
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SdkDefaultSecurityStateProvider

@Module
internal class SecurityStateProviderModule {

    @Provides
    @Singleton
    @SdkDefaultSecurityStateProvider
    fun provideDefaultSecurityStateProvider(): SecurityStateProvider =
        SecurityStateProviderImpl(SecurityCheckSpec.Default, true)

    @Provides
    fun provideSecurityStateProviderFactory(): SecurityStateProviderFactory =
        SecurityStateProviderFactoryImpl()
}