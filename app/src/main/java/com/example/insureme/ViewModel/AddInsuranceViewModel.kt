package com.example.insureme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.insureme.Views.adminhome
import com.example.insureme.DataClasses.postdataclass
import com.example.insureme.Views.LoginActivity
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddInsuranceViewModel: ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("http://10.20.37.60:5000/carInsurance/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun pushInsuranceData(cinsurance: postdataclass, onSuccess: () -> Unit, onError: (Throwable) -> Unit) {
        viewModelScope.launch {
            try {
                apiService.pushInsuranceData(cinsurance)
                onSuccess()
            } catch (t: Throwable) {
                onError(t)
            }
        }
    }
}
class pushInsurance : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_healthinsurance)
        lateinit var insuranceViewModel: AddInsuranceViewModel
        val addInsurance = findViewById<Button>(R.id.addInsuranceButton)
        val insurance_title=findViewById<EditText>(R.id.addCarInsuranceName)
        val insurance_description=findViewById<EditText>(R.id.addCarInsuranceDesc)
        val insurance_price=findViewById<EditText>(R.id.addCarInsurancePrice)
        insuranceViewModel = ViewModelProvider(this).get(AddInsuranceViewModel::class.java)

       addInsurance.setOnClickListener {

            val title = insurance_title.text.toString()
            val description = insurance_description.text.toString()
            val type="CAR"
            val price = insurance_price.text.toString().toDouble()

            val insurance = postdataclass(title, description,type, price)

            insuranceViewModel.pushInsuranceData(insurance, onSuccess = {
                  print("SUCCESSSSSSS")
                setContentView(R.layout.final_add_isnurance_checkout)
                // handle success
            }, onError = {
                // handle error
                print("OYE OYE")
            })
        }

    }
    fun goToPreLogin(view: View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}