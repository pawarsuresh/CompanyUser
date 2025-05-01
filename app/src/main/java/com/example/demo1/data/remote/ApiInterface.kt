package com.example.demo1.data.remote

import com.example.demo1.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    suspend fun getUser() : List<User>

    @GET("users/{id}")
    suspend fun getUserDetail(@Path("id") id:Int) : User
}