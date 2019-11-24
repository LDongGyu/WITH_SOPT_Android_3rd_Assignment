package com.example.kotlin_sopt_1.feature.follower

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sopt_1.R
import com.example.kotlin_sopt_1.api.GithubServiceImpl
import com.example.kotlin_sopt_1.data.user.GetFollowersData
import com.example.kotlin_sopt_1.data.user.GetUserData
import kotlinx.android.synthetic.main.activity_github_follower.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class GithubFollowerActivity : AppCompatActivity() {

    private lateinit var rvGitFollower: RecyclerView
    private lateinit var gitFollowerAdapter: GitFollowerAdapter
    private var login: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_follower)
        login = intent.getStringExtra("id")
        makeController()
    }

    private fun makeController(){
        makeProfile()
        initGitFollowerList()
    }

    private fun makeProfile(){
        val call: Call<GetUserData> = GithubServiceImpl.service.getUser(login)
//        lateinit var bitmap: Bitmap

        call.enqueue(
            object : Callback<GetUserData> {
                override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                    Log.e("sopt_git_star","error : $t")
                }

                override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                    if(response.isSuccessful){
                        val gitRepos = response.body()!!
                        main_id_txt.text = gitRepos.login
                        main_name_txt.text = gitRepos.name
                        main_dist_txt.text = gitRepos.bio

                        Thread{
                            try{
                                var url = URL(gitRepos.avatarUrl)
                                var conn = url.openConnection() as HttpURLConnection
                                conn.doInput = true
                                conn.connect()
                                var isConn: InputStream = conn.getInputStream()
                                var bitmap = BitmapFactory.decodeStream(isConn)
                                runOnUiThread {
                                    profile_imageView.setImageBitmap(bitmap)
                                }

                            }catch (e: Exception){
                                Log.d("test",e.toString())
                            }
                        }.start()
                    }
                }
            }
        )
    }
    private fun initGitFollowerList(){
        rvGitFollower = findViewById(R.id.gitFollower_rv)
        gitFollowerAdapter = GitFollowerAdapter(this)
        rvGitFollower.adapter = gitFollowerAdapter
        rvGitFollower.layoutManager = LinearLayoutManager(this)
        val call: Call<List<GetFollowersData>> = GithubServiceImpl.service.getFollowers(login)

        call.enqueue(
            object : Callback<List<GetFollowersData>>{
                override fun onFailure(call: Call<List<GetFollowersData>>, t: Throwable) {
                    Log.e("sopt_git_star","error : $t")
                }

                override fun onResponse(
                    call: Call<List<GetFollowersData>>,
                    response: Response<List<GetFollowersData>>
                ) {
                    if(response.isSuccessful){
                        val gitFollowers = response.body()
                        if (gitFollowers != null) {
                            gitFollowerAdapter.data = gitFollowers
                        }
                    }
                }
            }
        )

        gitFollowerAdapter.notifyDataSetChanged()
    }
}
