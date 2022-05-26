package com.example.wallpapers.retrofit


import com.example.recyclerviewpagination.models.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun getUsers(@Query("page") page:Int): Call<UserData>

    @GET("users")
    suspend fun getUsers2(@Query("page") page:Int): UserData
}