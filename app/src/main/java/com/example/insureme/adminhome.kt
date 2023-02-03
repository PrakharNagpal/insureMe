package com.example.insureme

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class adminhome : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_home_page)
    }
        fun onAddInsuranceClick(view: View)
        {

            startActivity(Intent(this,pushInsurance::class.java))

        }



    }

//    fun onUserLoginClick(view: View) {
////        val moveToLoginScreen=findViewById<Button>(R.id.userLoginButton)
////        moveToLoginScreen.setOnClickListener{
//        startActivity(Intent(this,UserLoginActivity::class.java))
//
//        // Do something on user login button click
//    }
//
//    fun onAdminLoginClick(view: View) {
//
//        // Do something on admin login button click
//    }



class addNewInsurance:AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.add_healthinsurance)
    }
}