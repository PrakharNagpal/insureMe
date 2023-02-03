package com.example.insureme.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.insureme.InsuranceApiService
import com.example.insureme.ServiceBuilder
import com.example.insureme.Views.carinsurance_dataclass

class CarInsuranceViewModel : ViewModel() {
    val insurances = MutableLiveData<List<carinsurance_dataclass>>()

     suspend fun fetchInsurances() {
        val insuranceinterface= ServiceBuilder.buildService(InsuranceApiService::class.java)
        val response = insuranceinterface.getInsurances()
         print(insurances)
        insurances.postValue(response)
    }
}