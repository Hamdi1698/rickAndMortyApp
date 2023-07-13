package com.rickandmortyapp.api

import com.rickandmortyapp.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



    val api: SimpleApi =
        retrofit.create(SimpleApi::class.java)

}