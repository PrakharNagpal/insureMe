package com.example.insureme

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarInsuranceViewModel : ViewModel() {
    val insurances = MutableLiveData<List<carinsurance_dataclass>>()

     suspend fun fetchInsurances() {
        val insuranceinterface=ServiceBuilder.buildService(InsuranceApiService::class.java)
        val response = insuranceinterface.getInsurances()
         print(insurances)
        insurances.postValue(response)
    }
}