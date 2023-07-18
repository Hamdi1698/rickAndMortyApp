package com.rickandmortyapp.api




import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.locationmodel.LocationData
import retrofit2.Response


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
    suspend fun getLocation(page: Int):Response<LocationData> {
        return  RetrofitInstance.apiLocation.test1(page)
    }

}
