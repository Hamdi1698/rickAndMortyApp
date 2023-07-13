package com.rickandmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmortyapp.model.CharacterList
import com.rickandmortyapp.api.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(private val repository: Repository) : ViewModel() {
    var listCharacters = MutableLiveData<Response<CharacterList>>()

    fun getCharacters(page: Int) {
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            listCharacters.value = characters
        }
    }
}