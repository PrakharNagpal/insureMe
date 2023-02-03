package com.example.insureme

import com.example.insureme.DataClasses.carinsurance_dataclass
import retrofit2.http.GET

interface InsuranceApiService {
    @GET("get")
    suspend fun getInsurances(): List<carinsurance_dataclass>
}