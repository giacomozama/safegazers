package test.safegazers.domain.use_case

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import test.safegazers.sdk.domain.service.SafeStargazersService

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetStargazersPagerUseCase(
        @ApplicationContext context: Context,
        safeStargazersService: SafeStargazersService
    ): GetStargazersPagerUseCase = GetStargazersPagerUseCase(context, safeStargazersService)
}