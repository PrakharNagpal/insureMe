package com.example.insureme

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InsuranceViewModel : ViewModel() {
    val insurances = MutableLiveData<List<insurance_dataclass>>()

     suspend fun fetchInsurances() {
        val insuranceinterface=ServiceBuilder.buildService(InsuranceApiService::class.java)
        val response = insuranceinterface.getInsurances()
        insurances.postValue(response)
    }
}