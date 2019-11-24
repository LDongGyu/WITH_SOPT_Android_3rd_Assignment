package com.example.kotlin_sopt_1.feature.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_sopt_1.R
import com.example.kotlin_sopt_1.feature.follower.GithubFollowerActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        controller()
    }

    fun controller(){
        signUp_btn.setOnClickListener {
            val name = name_edit.text.toString()
            val id = id_edit.text.toString()
            val pw = pw_edit.text.toString()
            val pw_confirm = pw_confirm_edit.text.toString()

            if(name.isEmpty()){
                Toast.makeText(this,"이름이 비어있습니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(id.isEmpty()){
                Toast.makeText(this,"아이디가 비어있습니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pw.isEmpty()){
                Toast.makeText(this,"비밀번호가 비어있습니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pw_confirm.isEmpty()){
                Toast.makeText(this,"비밀번호 확인을 해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!pw.equals(pw_confirm)){
                Toast.makeText(this,"비밀번호가 다릅니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this,
                GithubFollowerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
