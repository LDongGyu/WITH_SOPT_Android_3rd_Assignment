package com.example.kotlin_sopt_1.api

import com.example.kotlin_sopt_1.data.user.GetFollowersData
import com.example.kotlin_sopt_1.data.git_repo.GetGitRepoData
import com.example.kotlin_sopt_1.data.user.GetUserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService{
    @GET("/users/{login}")
    fun getUser(
        @Path("login") login: String
    ): Call<GetUserData>

    @GET("/users/{login}/followers")
    fun getFollowers(
        @Path("login") login: String
    ): Call<List<GetFollowersData>>

    @GET("/users/{login}/repos")
    fun getRepos(
        @Path("login") login: String
    ): Call<List<GetGitRepoData>>
}