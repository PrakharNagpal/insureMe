package com.example.insureme

import retrofit2.http.GET

interface InsuranceApiService {
    @GET("get")
    suspend fun getInsurances(): List<carinsurance_dataclass>
}