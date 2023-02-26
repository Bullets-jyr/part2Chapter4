package kr.co.bullets.part2chapter4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.bullets.part2chapter4.adapter.RepoAdapter
import kr.co.bullets.part2chapter4.databinding.ActivityRepoBinding
import kr.co.bullets.part2chapter4.model.Repo
import kr.co.bullets.part2chapter4.network.GitHubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepoBinding

    private lateinit var repoAdapter: RepoAdapter

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("userName") ?: return

        binding.userNameTextView.text = userName

        repoAdapter = RepoAdapter()

        binding.repoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RepoActivity)
            adapter = repoAdapter
        }

        listRepo(userName)
    }

    private fun listRepo(userName: String) {
        val gitHubService = retrofit.create(GitHubService::class.java)

        gitHubService.listRepos(userName).enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.e("MainActivity", "List Repo : ${response.body().toString()}")

                repoAdapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {

            }
        })
    }
}