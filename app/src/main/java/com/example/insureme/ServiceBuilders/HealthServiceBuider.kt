package com.example.insureme


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HealthServiceBuilder {
    private const val healthURL ="http://10.20.37.60:5000/healthInsurance/"
    //CREATE HTTP CLIENT
//        private val okHttp =OkHttpClient.Builder()

    //retrofit builder
    private val healthbuilder =Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create()).baseUrl(healthURL)
//            .client(okHttp.build())

    //create retrofit Instance
    private val healthretrofit = healthbuilder.build()

    //we will use this class to create an anonymous inner class function that
    //implements Country service Interface


    fun <T> buildService (serviceType :Class<T>):T{
        return healthretrofit.create(serviceType)
    }

}
