package com.example.insureme

import retrofit2.http.GET
import retrofit2.Call

interface InsuranceApiService {
    @GET("get")
    suspend fun getInsurances(): List<insurance_dataclass>
}