package com.example.kotlin_sopt_1.data.git_repo

import com.google.gson.annotations.SerializedName

data class GetGitRepoData(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("language")
    val language: String?
)