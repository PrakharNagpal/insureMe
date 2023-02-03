package com.example.insureme


import com.example.insureme.DataClasses.postdataclass
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("add")
    suspend fun pushInsuranceData(@Body cinsurance: postdataclass): Response<Void>
}
