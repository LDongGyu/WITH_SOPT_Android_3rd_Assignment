package com.example.kotlin_sopt_1.feature.follower

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sopt_1.R
import com.example.kotlin_sopt_1.data.user.GetFollowersData

class GitFollowerAdapter(private val context: Context): RecyclerView.Adapter<GitFollowerViewHolder>(){

    var data : List<GetFollowersData> = listOf<GetFollowersData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitFollowerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.github_follower_item,parent,false)
        return GitFollowerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: GitFollowerViewHolder, position: Int) {
        holder.bind(data!![position])
    }

}