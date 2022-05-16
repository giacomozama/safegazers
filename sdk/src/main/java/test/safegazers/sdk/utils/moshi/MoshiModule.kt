package test.safegazers.sdk.utils.moshi

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SdkMoshi

@Module
internal class MoshiModule {

    @Provides
    @Singleton
    fun provideLocalDateTimeAdapter(): LocalDateTimeAdapter = LocalDateTimeAdapter()

    @Provides
    @Singleton
    @SdkMoshi
    fun provideMoshi(localDateTimeAdapter: LocalDateTimeAdapter): Moshi = Moshi.Builder()
        .add(localDateTimeAdapter)
        .build()
}