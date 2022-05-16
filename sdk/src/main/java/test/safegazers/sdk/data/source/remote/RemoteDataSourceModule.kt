package test.safegazers.sdk.data.source.remote

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import test.safegazers.sdk.utils.moshi.SdkMoshi
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SdkGitHubApiRetrofit

@Module
internal class RemoteDataSourceModule {

    @Provides
    @Singleton
    @SdkGitHubApiRetrofit
    fun provideRetrofit(@SdkMoshi moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl(GitHubRemoteDataSource.BaseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    fun provideGitHubRemoteDataSource(@SdkGitHubApiRetrofit retrofit: Retrofit): GitHubRemoteDataSource =
        retrofit.create(GitHubRemoteDataSource::class.java)
}