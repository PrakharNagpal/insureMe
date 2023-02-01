package com.example.insureme
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class Select_Insurance : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.choose_insurancetype)
        val carcard: CardView =findViewById<CardView>(R.id.CarCard)!!
        val healthcard: CardView =findViewById<CardView>(R.id.HealthCard)!!

            carcard.setOnClickListener {
                Toast.makeText(this, "Car Insurance selected", Toast.LENGTH_SHORT).show()
            }

            healthcard.setOnClickListener {
                Toast.makeText(this, "Health Insurance selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
