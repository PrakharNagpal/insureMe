package com.example.insureme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pre_login_signup)
    }
    fun onUserLoginClick(view: View) {
        val moveToLoginScreen=findViewById<Button>(R.id.userLoginButton)
        moveToLoginScreen.setOnClickListener{
            startActivity(Intent(this,UserLoginActivity::class.java))
        }
        // Do something on user login button click
    }

}