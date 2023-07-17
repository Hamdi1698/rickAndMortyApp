package com.rickandmortyapp.api

import com.rickandmortyapp.model.TestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SimpleApi {


    @GET("api/character")
    suspend fun test(@Query("page") page:Int): Response<TestResponse>

    @GET("api/character")
    suspend fun testByStatusAndGender(@Query("status") status:String,
                                      @Query("gender")gender:String,
                                      @Query("page") page:Int): Response<TestResponse>

    @GET("api/character")
    suspend fun testByStatus(@Query("status") status: String,
                             @Query("page") page:Int): Response<TestResponse>

    @GET("api/character")
    suspend fun testByGender(@Query("gender") gender: String,
        @Query("page") page:Int): Response<TestResponse>
}