package com.example.insureme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.insureme.Views.adminhome
import com.example.insureme.DataClasses.postdataclass
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddHealthInsuranceViewModel: ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("http://10.20.37.60:5000/healthInsurance/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun pushInsuranceData(hinsurance: postdataclass, onSuccess: () -> Unit, onError: (Throwable) -> Unit) {
        viewModelScope.launch {
            try {
                apiService.pushInsuranceData(hinsurance)
                onSuccess()
            } catch (t: Throwable) {
                onError(t)
            }
        }
    }
}
class pushHealthInsurance : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_healthinsurance)
        lateinit var insuranceViewModel: AddHealthInsuranceViewModel
        val addInsurance = findViewById<Button>(R.id.addInsuranceButton)
        val insurance_title=findViewById<EditText>(R.id.addCarInsuranceName)
        val insurance_description=findViewById<EditText>(R.id.addCarInsuranceDesc)
        val insurance_price=findViewById<EditText>(R.id.addCarInsurancePrice)
        insuranceViewModel = ViewModelProvider(this).get(AddHealthInsuranceViewModel::class.java)

        addInsurance.setOnClickListener {
            val title = insurance_title.text.toString()
            val description = insurance_description.text.toString()
            val type="Health"
            val price = insurance_price.text.toString().toDouble()

            val insurance = postdataclass(title, description,type, price)

            insuranceViewModel.pushInsuranceData(insurance, onSuccess = {
                print("SUCCESSSSSSS")
                startActivity(Intent(this, adminhome::class.java))
                // handle success
            }, onError = {
                // handle error
                print("OYE OYE")
            })
        }
    }
}