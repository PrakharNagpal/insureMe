package com.example.insureme.Views
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.insureme.R

class Select_Insurance : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.choose_insurancetype)
            val carcard: CardView =findViewById<CardView>(R.id.CarCard)!!
            val healthcard: CardView =findViewById<CardView>(R.id.HealthCard)

            carcard.setOnClickListener {
                Toast.makeText(this, "Car Insurance selected", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Carinsuranceuserdetails::class.java))
            }

            healthcard.setOnClickListener {
                startActivity(Intent(this, healthinsuranceuserdetails::class.java))
                Toast.makeText(this, "Health Insurance selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
