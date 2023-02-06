package com.example.insureme

import retrofit2.Call

import retrofit2.http.DELETE
import retrofit2.http.Path

interface ApiServiceDelete {
    @DELETE("delete/{id}")
    fun deleteData(@Path("id") id: String): Call<Void>

}

