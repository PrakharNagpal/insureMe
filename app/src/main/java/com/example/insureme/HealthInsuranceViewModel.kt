package com.example.insureme

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HealthInsuranceViewModel : ViewModel() {
    val Healthinsurances = MutableLiveData<List<healthinsurance_dataclass>>()

    suspend fun healthfetchInsurances() {
        val healthinsuranceinterface=HealthServiceBuilder.buildService(HealthInsuranceApiService::class.java)
        val response = healthinsuranceinterface.getHealthInsurances()
       // print(insurances)
        Healthinsurances.postValue(response)
    }
}