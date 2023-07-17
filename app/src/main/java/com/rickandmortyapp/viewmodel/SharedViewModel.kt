package com.rickandmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.model.TestResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(private val repository: Repository) : ViewModel() {
    var resultsCharacters = MutableLiveData<Response<TestResponse>>()
    var filterValue = MutableLiveData<Array<Int>>()
    var isFilter = MutableLiveData<Boolean>()

    init {
        filterValue.value = arrayOf(0, 0)
        isFilter.value = false
    }

    fun getCharacters(page: Int) {
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            resultsCharacters.value = characters
        }
    }
    fun testByStatusAndGender(status:String,gender:String,page: Int){
        viewModelScope.launch {
            val characters =repository.testByStatusAndGender(status, gender, page)
            resultsCharacters.value = characters
        }
    }
    fun testByStatus(status:String,page: Int){
        viewModelScope.launch {
            val characters =repository.testByStatus(status,page)
            resultsCharacters.value = characters
        }
    }
    fun testByGender(gender:String,page: Int){
        viewModelScope.launch {
            val characters =repository.testByGender( gender, page)
            resultsCharacters.value = characters
        }
    }

}