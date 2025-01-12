package com.example.colocviu.network

import com.example.colocviu.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products/search") //folosind GET ne atasam la api si luam produsele din api
    suspend fun searchProducts(@Query("q") query: String): ProductResponse
}
