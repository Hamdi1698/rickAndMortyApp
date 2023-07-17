package com.rickandmortyapp.api

import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.locationmodel.ResultLocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApiLocation {

    @GET("api/location")
    suspend fun test1(@Query("id") id:Int): Response<ResultLocation>
}