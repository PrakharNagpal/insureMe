package com.example.insureme.Views

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.insureme.R
import org.w3c.dom.Text

class standard_packageinsurancepage_health:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.health_insurance_desc_page)
        val companytitle=intent.getStringExtra("title")
        val companyprice=intent.getStringExtra("price")
        val companydesc=intent.getStringExtra("desc")
        val healthcompanydesc=findViewById<TextView>(R.id.healthcompanydesc)
        val healthcompanytitle=findViewById<TextView>(R.id.healthcompanytextview)
        val healthcompantprice=findViewById<TextView>(R.id.healthpricetextview)
        healthcompanytitle.text = companytitle
        healthcompantprice.text="₹" + companyprice
        healthcompanydesc.text=companydesc
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
        val companytitle=intent.getStringExtra("title")
        val companyprice=intent.getStringExtra("price")
        val companydesc=intent.getStringExtra("desc")
        val healthcompanydesc=findViewById<TextView>(R.id.cardesctextview)
        val healthcompanytitle=findViewById<TextView>(R.id.cartitletextview)
        val healthcompantprice=findViewById<TextView>(R.id.carpricetextview)
        healthcompanytitle.text = companytitle
        healthcompantprice.text="₹" + companyprice
        healthcompanydesc.text=companydesc

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
