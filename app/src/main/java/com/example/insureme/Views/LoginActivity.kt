package com.example.insureme.Views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.insureme.R

class LoginActivity : AppCompatActivity() {
    private lateinit var loginIdEditText: EditText
    private lateinit var passwordEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pre_login_signup)



    }
    fun onUserLoginClick(view: View) {
//        val moveToLoginScreen=findViewById<Button>(R.id.userLoginButton)
//        moveToLoginScreen.setOnClickListener{
            startActivity(Intent(this, UserLoginActivity::class.java))

        // Do something on user login button click
    }

    fun onAdminLoginClick(view: View) {
        startActivity(Intent(this, adminLogin::class.java))

        // Do something on admin login button click
    }


}