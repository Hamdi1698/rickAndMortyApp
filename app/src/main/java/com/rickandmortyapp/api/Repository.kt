package com.rickandmortyapp.api


import com.rickandmortyapp.Constants
import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.kk.CharacterList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    suspend fun getCharacters(page:Int):retrofit2.Response<TestResponse>{
         val retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()



        val api: SimpleApi =
            retrofit.create(SimpleApi::class.java)
        return api.test(page)
    }
}