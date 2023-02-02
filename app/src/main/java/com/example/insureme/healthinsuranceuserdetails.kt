package com.example.insureme

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class healthinsuranceuserdetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_user_details1)
        val healthContinue1=findViewById<Button>(R.id.healthContinue1)


        healthContinue1 .setOnClickListener {
            startActivity(Intent(this, healthinsuranceuserdetails1::class.java))
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

        }

    }


}
class healthinsuranceuserdetails1:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_user_details2)
        val healthContinue2 = findViewById<Button>(R.id.healthContinue2)
        healthContinue2.setOnClickListener {
            startActivity(Intent(this, healthinsuranceuserdetails2::class.java))
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

        }
    }


}
class healthinsuranceuserdetails2:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_user_details3)
        val healthContinue2 = findViewById<Button>(R.id.healthContinue3)
        healthContinue2.setOnClickListener {
            startActivity(Intent(this, healthinsuranceuserdetails3::class.java))
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()


        }
    }
}
class healthinsuranceuserdetails3:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_user_details4)
        val heathContinue3=findViewById<Button>(R.id.healthContinue4)
        heathContinue3.setOnClickListener {
            startActivity(Intent(this, healthinsuranceuserdetails4::class.java))
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()


        }
    }
}
class healthinsuranceuserdetails4:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_user_details5)
        val healthContinue4 = findViewById<Button>(R.id.healthContinue5)
        healthContinue4.setOnClickListener {
            //startActivity(Intent(this, healthinsuranceuserdetails3::class.java))
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()


        }
    }
}

