package com.example.insureme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserLoginActivity : AppCompatActivity() {

    private lateinit var loginIdEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login)

        loginIdEditText = findViewById(R.id.loginIdEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
    }


    fun onLoginClick(view: View) {
        val loginbutton= findViewById<Button>(R.id.loginButton)
        val loginId = loginIdEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (loginId.isEmpty()) {
            loginIdEditText.error = "Login ID is required"
            loginIdEditText.requestFocus()
            return
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Password is required"
            passwordEditText.requestFocus()
            return
        }

        // Perform the actual login here
        // ...

        // Show a success message
        loginbutton.setOnClickListener{
            startActivity(Intent(this,Select_Insurance::class.java))
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

        }
    }
}