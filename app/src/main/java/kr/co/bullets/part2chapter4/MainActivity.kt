package kr.co.bullets.part2chapter4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.bullets.part2chapter4.model.Repo
import kr.co.bullets.part2chapter4.model.UserDto
import kr.co.bullets.part2chapter4.network.GitHubService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gitHubService = retrofit.create(GitHubService::class.java)
        gitHubService.listRepos("square").enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.e("MainActivity", "List Repo : ${response.body().toString()}")
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {

            }
        })

        gitHubService.searchUsers("square").enqueue(object : Callback<UserDto> {
            override fun onResponse(call: Call<UserDto>, response: Response<UserDto>) {
                Log.e("MainActivity", "Search User : ${response.body().toString()}")
            }

            override fun onFailure(call: Call<UserDto>, t: Throwable) {

            }
        })
    }
}