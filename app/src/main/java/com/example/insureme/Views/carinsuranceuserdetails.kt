package com.example.insureme.Views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.insureme.InsuranceActivityNew
import com.example.insureme.R

class Carinsuranceuserdetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.car_userdetails)
            val CarContinue1=findViewById<Button>(R.id.CarContinue1)


           CarContinue1 .setOnClickListener {
               startActivity(Intent(this, Carinsuranceuserdetails1::class.java))
              // Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

           }

    }


}
class Carinsuranceuserdetails1:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.car_userdetails1)
        val CarContinue2 = findViewById<Button>(R.id.CarContinue2)
        CarContinue2.setOnClickListener {
            startActivity(Intent(this, Carinsuranceuserdetails2::class.java))
          //  Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

        }
    }


}
    class Carinsuranceuserdetails2:AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.car_userdetails2)
            val CarContinue3=findViewById<Button>(R.id.CarContinue3)
            CarContinue3.setOnClickListener{
                startActivity(Intent(this, InsuranceActivityNew::class.java))
            }




        }
    }
