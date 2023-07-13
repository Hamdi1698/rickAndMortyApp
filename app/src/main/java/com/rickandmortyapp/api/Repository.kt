package com.rickandmortyapp.api


import com.rickandmortyapp.model.CharacterList

class Repository {
    suspend fun getCharacters(page:Int):retrofit2.Response<CharacterList>{
        return RetrofitInstance.api.getCharacters(page)
    }
}