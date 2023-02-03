package com.example.insureme
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChooseAddInsuranceType :AppCompatActivity(){
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_addinsurancetype)
        title = "KotlinApp"
        radioGroup = findViewById(R.id.radio_group_chooseInsurance)
        button = findViewById<Button>(R.id.chooseAddInsuraceButton)
        button.setOnClickListener {
            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(intSelectButton)
            if((radioButton.text).equals("Health Insurance"))
            {
                startActivity(Intent(this,pushHealthInsurance::class.java))
                Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()
            }
            if((radioButton.text).equals("Car Insurance"))
            {
                startActivity(Intent(this,pushInsurance::class.java))
                Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()
            }



        }
    }
}