package com.rickandmortyapp.api


import com.rickandmortyapp.model.locationmodel.LocationData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApiLocation {

    @GET("api/location")
    suspend fun test1(@Query("page") page:Int): Response<LocationData>
}