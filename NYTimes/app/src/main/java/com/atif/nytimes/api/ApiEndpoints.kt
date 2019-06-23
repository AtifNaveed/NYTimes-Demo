package com.atif.nytimes.api

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.atif.nytimes.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiEndpoints {
    var endpoints: ApiClient = ApiClient()

    fun getMostPopularNews(section: String, period: String): LiveData<ApiResponse> {
        val apiResponse = MutableLiveData<ApiResponse>()
        val apiService = endpoints.getClient()!!.create(ApiInterface::class.java)
        val call : Call<ApiResponse> = apiService.getData(section,period, Constant.api_key)
        call.enqueue(object : Callback<ApiResponse> {

            override fun onFailure(call: Call<ApiResponse>?, t: Throwable?) {
                Log.e("API", "FAILED WITH ERROR: $t.toString()")
            }

            override fun onResponse(call: Call<ApiResponse>?, response: Response<ApiResponse>?) {
                val statusCode = response?.code()
                if (statusCode == 200) {
                    apiResponse.postValue(response.body()!!)
                } else {
                    Log.e("API", "FAILED WITH RESPONSE: $response")
                }
            }
        })

        return apiResponse
    }
}