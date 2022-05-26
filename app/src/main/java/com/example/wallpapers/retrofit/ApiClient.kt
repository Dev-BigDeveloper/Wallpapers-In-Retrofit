package com.example.wallpapers.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = "https://reqres.in/api/"
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    var apiService: ApiService = getRetrofit().create(ApiService::class.java)
}