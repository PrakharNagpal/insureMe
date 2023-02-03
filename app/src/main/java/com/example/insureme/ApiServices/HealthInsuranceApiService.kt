package com.example.insureme.ApiServices

import com.example.insureme.Views.healthinsurance_dataclass
import retrofit2.http.GET

interface HealthInsuranceApiService {
    @GET("get")
    suspend fun getHealthInsurances(): List<healthinsurance_dataclass>
}