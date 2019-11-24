package com.example.kotlin_sopt_1.feature.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.kotlin_sopt_1.R
import com.example.kotlin_sopt_1.feature.signUp.SignUpActivity
import com.example.kotlin_sopt_1.feature.follower.GithubFollowerActivity

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val id_edit: EditText = findViewById(R.id.id_edit)
        val pass_edit: EditText = findViewById(R.id.pass_edit)
        val signIn_btn: Button = findViewById(R.id.signin_btn)
        val signUp_btn: Button = findViewById(R.id.signup_btn)

        signIn_btn.setOnClickListener {
            val intent: Intent = Intent(this, GithubFollowerActivity::class.java)
            intent.putExtra("id",id_edit.text.toString())
            startActivity(intent)
            finish()
        }

        signUp_btn.setOnClickListener{
            val intent: Intent = Intent(this, SignUpActivity::class.java)

            startActivity(intent)
            finish()
        }

    }
}
