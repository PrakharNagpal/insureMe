package com.example.insureme.Views

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.insureme.R

class standard_packageinsurancepage_health:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_insurance_desc_page)



    }
    fun gotoLastPageHealth(view: View)
    {
        startActivity(Intent(this,finalpage::class.java))
    }


}
class standard_packageinsurancepage_car:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.car_insurance_desc_page)

    }
    fun gotoLastPage(view: View)
    {
        startActivity(Intent(this,finalpage::class.java))
    }


}
class finalpage:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.last_page)
    }
}
