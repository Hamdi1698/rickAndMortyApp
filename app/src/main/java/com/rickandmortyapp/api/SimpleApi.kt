package com.rickandmortyapp.api

import com.rickandmortyapp.model.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SimpleApi {
    @GET("characters") // Örnek URL: "https://api.example.com/characters"
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterList>
}
