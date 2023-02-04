package com.example.insureme.Views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.insureme.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    lateinit var tvRedirectLogin: TextView

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // View Bindings
        etEmail = findViewById(R.id.signEmail)
        etConfPass = findViewById(R.id.ConfirmPassword)
        etPass = findViewById(R.id.SignPassword)
        btnSignUp = findViewById(R.id.signButton)
        //tvRedirectLogin = findViewById(R.id.tvRedirectLogin)

        // Initialising auth object
        auth = Firebase.auth

        btnSignUp.setOnClickListener {
            createAccount(etEmail.toString(),etPass.toString())
        }

        // switching from signUp Activity to Login Activity
//        tvRedirectLogin.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }
    private fun createAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Signup CHECK", "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("sIGNUP CHECK", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
        // [END create_user_with_email]
    }

//    private fun signUpUser() {
//        val email = etEmail.text.toString()
//        val pass = etPass.text.toString()
//        val confirmPassword = etConfPass.text.toString()
//
//        // check pass
//        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
//            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        if (pass != confirmPassword) {
//            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
//                .show()
//            return
//        }
//        // If all credential are correct
//        // We call createUserWithEmailAndPassword
//        // using auth object and pass the
//        // email and pass in it.
//        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
//            if (it.isSuccessful) {
//                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
//                finish()
//            } else {
//                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }
}
