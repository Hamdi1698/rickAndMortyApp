package com.rickandmortyapp.api


import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.kk.CharacterList

class Repository {
    suspend fun getCharacters(page:Int):retrofit2.Response<TestResponse>{
        return RetrofitInstance.api.getCharacters(page)
    }
}