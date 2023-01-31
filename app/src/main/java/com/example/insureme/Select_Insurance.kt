package com.example.insureme
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class Select_Insurance : AppCompatActivity() {

    private val carcard: CardView =findViewById<CardView>(R.id.CarCard)
    private val healthcard: CardView =findViewById<CardView>(R.id.HealthCard)
    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.choose_insurancetype)

            carcard.setOnClickListener {
                Toast.makeText(this, "Car Insurance selected", Toast.LENGTH_SHORT).show()
            }

            healthcard.setOnClickListener {
                Toast.makeText(this, "Health Insurance selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
