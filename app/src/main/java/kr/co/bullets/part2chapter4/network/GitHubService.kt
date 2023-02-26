package kr.co.bullets.part2chapter4.network

import kr.co.bullets.part2chapter4.model.Repo
import kr.co.bullets.part2chapter4.model.UserDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {

//    @Headers("Authorization: Bearer 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")
    @GET("users/{username}/repos")
    fun listRepos(@Path("username") userName: String, @Query("page") page: Int): Call<List<Repo>>

//    @Headers("Authorization: Bearer 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")
    @GET("search/users")
    fun searchUsers(@Query("q") q: String): Call<UserDto>
}