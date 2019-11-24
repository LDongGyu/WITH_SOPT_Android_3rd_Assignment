package com.example.kotlin_sopt_1.feature.repo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sopt_1.R
import com.example.kotlin_sopt_1.api.GithubServiceImpl
import com.example.kotlin_sopt_1.data.git_repo.GitRepoItem
import com.example.kotlin_sopt_1.data.user.GetUserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepoActivity : AppCompatActivity() {

    private lateinit var rvGitRepo: RecyclerView
    private lateinit var gitRepoAdapter: GitRepoAdapter
    private var login: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_repo)

        makeController()

    }

    private fun makeController(){
        makeProfile()
        initGitRepoList()
    }

    private fun makeProfile(){
        val call: Call<GetUserData> = GithubServiceImpl.service.getUser(login)

        call.enqueue(
            object : Callback<GetUserData>{
                override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                    Log.e("sopt_git_star","error : $t")
                }

                override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                    if(response.isSuccessful){
                        val gitRepos = response.body()!!

                    }
                }

            }
        )
    }
    private fun initGitRepoList(){
        rvGitRepo = findViewById(R.id.gitRepo_rv)
        gitRepoAdapter =
            GitRepoAdapter(this)
        rvGitRepo.adapter = gitRepoAdapter
        rvGitRepo.layoutManager = LinearLayoutManager(this)

        gitRepoAdapter.data = listOf(
            GitRepoItem(
                name = "SoptStagram",
                dist = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                language = "Kotlin",
                language_color = 0
            ),
            GitRepoItem(
                name = "우아",
                dist = "두번째 과제",
                language = "Kotlin",
                language_color = 0
            ),
            GitRepoItem(
                name = "취업시켜주세요",
                dist = "LG전자 합격시켜주세요",
                language = "Kotlin",
                language_color = 0
            ),
            GitRepoItem(
                name = "LG전자 MC본부",
                dist = "안드로이드 개발할래요",
                language = "Kotlin",
                language_color = 0
            )
        )
        gitRepoAdapter.notifyDataSetChanged()
    }
}
