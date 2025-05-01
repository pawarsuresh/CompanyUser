package com.example.demo1.data.remote

import com.example.demo1.data.model.CatFact
import retrofit2.http.GET

interface CatInterface {
    @GET("fact")
    suspend fun getCatData() : CatFact
}