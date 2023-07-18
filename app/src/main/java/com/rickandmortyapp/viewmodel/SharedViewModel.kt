package com.rickandmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.locationmodel.LocationData
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(private val repository: Repository) : ViewModel() {
    var getLocation = MutableLiveData<Response<LocationData>>()
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
    fun getLocation(page: Int){
        viewModelScope.launch {
            val locations =repository.getLocation(page)
            getLocation.value =locations
        }
    }

}