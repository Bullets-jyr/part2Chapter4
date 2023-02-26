package kr.co.bullets.part2chapter4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.bullets.part2chapter4.databinding.ActivityRepoBinding

class RepoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}