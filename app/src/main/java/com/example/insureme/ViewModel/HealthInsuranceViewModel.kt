package com.example.insureme.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.insureme.ApiServices.HealthInsuranceApiService
import com.example.insureme.HealthServiceBuilder
import com.example.insureme.Views.healthinsurance_dataclass

class HealthInsuranceViewModel : ViewModel() {
    val Healthinsurances = MutableLiveData<List<healthinsurance_dataclass>>()

    suspend fun healthfetchInsurances() {
        val healthinsuranceinterface=
            HealthServiceBuilder.buildService(HealthInsuranceApiService::class.java)
        val response = healthinsuranceinterface.getHealthInsurances()
       // print(insurances)
        Healthinsurances.postValue(response)
    }
}