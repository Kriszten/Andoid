package com.example.smartcoffeemaker.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    @GET("/")
    suspend fun getLedState() : Response<Led>
}