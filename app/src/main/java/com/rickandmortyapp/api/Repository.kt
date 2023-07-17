package com.rickandmortyapp.api


import com.rickandmortyapp.Constants
import com.rickandmortyapp.model.Results
import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.locationmodel.ResultLocation
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    suspend fun getCharacters(page:Int): Response<TestResponse> {
        return RetrofitInstance.api.test(page)
    }
        suspend fun testByStatusAndGender(status:String,gender:String,page:Int): Response<TestResponse> {
            return  RetrofitInstance.api.testByStatusAndGender(status, gender, page)

    }
         suspend fun testByStatus(status:String,page:Int): Response<TestResponse> {
             return RetrofitInstance.api.testByStatus(status, page)
         }
    suspend fun testByGender(gender:String,page:Int): Response<TestResponse> {
        return RetrofitInstance.api.testByGender(gender, page)
    }
    suspend fun getLocation(id:Int):Response<ResultLocation> {
        return  RetrofitInstance.apilocation.test1(id)
    }

}
