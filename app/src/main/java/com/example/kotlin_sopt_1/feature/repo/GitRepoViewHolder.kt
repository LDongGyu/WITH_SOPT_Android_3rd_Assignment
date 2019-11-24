package com.example.kotlin_sopt_1.feature.repo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sopt_1.R
import com.example.kotlin_sopt_1.data.git_repo.GitRepoItem

class GitRepoViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val name_txt: TextView = view.findViewById(R.id.name_txt)
    val dist_txt: TextView = view.findViewById(R.id.dist_txt)
    val ctg_img: ImageView = view.findViewById(R.id.ctg_img)
    val lang_txt: TextView = view.findViewById(R.id.lang_txt)

    fun bind(data: GitRepoItem){
        name_txt.text = data.name
        dist_txt.text = data.dist
        lang_txt.text = data.language
    }
}