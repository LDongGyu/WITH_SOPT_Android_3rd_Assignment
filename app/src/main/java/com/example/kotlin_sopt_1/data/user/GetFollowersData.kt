package com.example.kotlin_sopt_1.data.user

import com.google.gson.annotations.SerializedName

class GetFollowersData(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)