package com.example.insureme

import retrofit2.http.GET

interface HealthInsuranceApiService {
    @GET("get")
    suspend fun getHealthInsurances(): List<healthinsurance_dataclass>
}