package com.example.insureme.Views

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.insureme.R

class adminLogin : AppCompatActivity() {

    private lateinit var loginIdEditText: EditText
    private lateinit var passwordEditText: EditText
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_login)

        loginIdEditText = findViewById(R.id.adminloginIdEditText)
        passwordEditText = findViewById(R.id.adminpasswordEditText)
    }
    fun onAdminLoginClick(view: View) {
        val loginbutton= findViewById<Button>(R.id.adminloginButtonnew)
        val loginId = loginIdEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        if (Patterns.EMAIL_ADDRESS.matcher(loginId).matches()) {
            Toast.makeText(applicationContext, "Valid email address",
                Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, adminhome::class.java))
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()


        } else {
            Toast.makeText(applicationContext, "Invalid email address",
                Toast.LENGTH_SHORT).show()
            loginIdEditText.requestFocus()
            return

        }
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



    }
}