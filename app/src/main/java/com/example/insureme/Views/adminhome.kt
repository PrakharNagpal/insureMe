package com.example.insureme.Views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.insureme.R
import com.example.insureme.pushHealthInsurance
import com.example.insureme.pushInsurance


class adminhome : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_home_page)
    }
        fun onAddInsuranceClick(view: View)
        {

            startActivity(Intent(this, pushHealthInsurance::class.java))

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