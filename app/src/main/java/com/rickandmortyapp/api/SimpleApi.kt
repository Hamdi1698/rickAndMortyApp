package com.rickandmortyapp.api

import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.kk.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SimpleApi {


    @GET("api/character")
    suspend fun test(@Query("page") page:Int): Response<TestResponse>
}