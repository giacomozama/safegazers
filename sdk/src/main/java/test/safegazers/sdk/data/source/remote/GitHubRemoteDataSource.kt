package test.safegazers.sdk.data.source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import test.safegazers.sdk.domain.entities.JsonStargazer

internal interface GitHubRemoteDataSource {

    @Headers("Accept: application/vnd.github.v3.star+json")
    @GET("repos/{owner}/{repo}/stargazers")
    suspend fun getStargazers(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 100,
        @Query("page") page: Int = 1
    ): Response<List<JsonStargazer>>

    companion object {

        const val BaseUrl = "https://api.github.com/"
    }
}