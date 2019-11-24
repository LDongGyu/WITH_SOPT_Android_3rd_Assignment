package com.example.kotlin_sopt_1.feature.follower

import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sopt_1.R
import com.example.kotlin_sopt_1.data.user.GetFollowersData
import com.example.kotlin_sopt_1.data.user.GitFollowerItem
import kotlinx.android.synthetic.main.activity_github_follower.*
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class GitFollowerViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val id_txt: TextView = view.findViewById(R.id.id_txt)
    val profile_img: ImageView = view.findViewById(R.id.profile_img)

    fun bind(data: GetFollowersData){
        id_txt.text = data.login

        Thread{
            try{
                var url = URL(data.avatarUrl)
                var conn = url.openConnection()
                conn.doInput = true
                conn.connect()
                var isConn: InputStream = conn.getInputStream()
                var bitmap = BitmapFactory.decodeStream(isConn)
                profile_img.setImageBitmap(bitmap)
            }catch (e: Exception){
                Log.d("test",e.toString())
            }
        }.start()
    }
}