package com.example.insureme.Views
import android.util.Patterns;
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//
//class User_Login : AppCompatActivity() {
//
//
//    private lateinit var tvRedirectSignUp: TextView
//    lateinit var etEmail: EditText
//    private lateinit var etPass: EditText
//    lateinit var btnLogin: Button
//
//    // Creating firebaseAuth object
//    lateinit var auth: FirebaseAuth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.user_login)
//
//        // View Binding
//        //tvRedirectSignUp = findViewById(R.id.tvRedirectSignUp)
//        btnLogin = findViewById(R.id.loginButton)
//        etEmail = findViewById(R.id.loginIdEditText)
//        etPass = findViewById(R.id.passwordEditText)
//
//        // initialising Firebase auth object
//        auth = FirebaseAuth.getInstance()
//
//        btnLogin.setOnClickListener {
//            signIn(etEmail.toString(),etPass.toString())
//        }
//
//
//    private fun signIn(email: String, password: String) {
//        // [START sign_in_with_email]
//        auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d("Login Activity", "signInWithEmail:success")
//                    val user = auth.currentUser
//                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w("Login Activity", "signInWithEmail:failure", task.exception)
//                    Toast.makeText(baseContext, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
//                    updateUI(null)
//                }
//            }
//        // [END sign_in_with_email]
//    }
//
//    private fun updateUI(user: FirebaseUser?) {
//        Log.d("Login","Login skjsd")
//
//    }
//
//    private fun reload() {
//        Log.d("RELOAD","RELOAD")
//    }
//
//
//    private fun login() {
//        val email = etEmail.text.toString()
//        val pass = etPass.text.toString()
//        // calling signInWithEmailAndPassword(email, pass)
//        // function using Firebase auth object
//        // On successful response Display a Toast
//        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
//            if (it.isSuccessful) {
//                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
//            } else {
//
//                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//    }
//




import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.insureme.R

class UserLoginActivity : AppCompatActivity() {

    private lateinit var loginIdEditText: EditText
    private lateinit var passwordEditText: EditText
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"

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
        if ((Patterns.EMAIL_ADDRESS.matcher(loginId).matches())&&loginId.equals("user@insureme.com")&&password.toString().equals("user123")) {
            Toast.makeText(applicationContext, "Valid email address",
                Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, Select_Insurance::class.java))
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()


        } else {
            Toast.makeText(applicationContext, "Invalid Credentials",
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