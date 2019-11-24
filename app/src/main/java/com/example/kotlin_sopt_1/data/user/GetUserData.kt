package com.example.kotlin_sopt_1.data.user

import com.google.gson.annotations.SerializedName

class GetUserData (
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("followers")
    val numOffollowers: Int
)