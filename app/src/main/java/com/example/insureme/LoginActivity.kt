package com.example.insureme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pre_login_signup)

    }

    fun onAdminLoginClick(view: View) {

        // Do something on admin login button click
    }

    fun onUserLoginClick(view: View) {
        // Do something on user login button click
    }
}