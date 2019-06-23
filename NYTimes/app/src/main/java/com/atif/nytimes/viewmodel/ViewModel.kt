package com.atif.nytimes.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.atif.nytimes.api.ApiEndpoints
import com.atif.nytimes.api.ApiResponse

class ViewModel(private val apiEndPoint: ApiEndpoints): ViewModel() {
    private var data: LiveData<ApiResponse>? = null

    fun getNewsData(refresh: Boolean, section: String, period: String): LiveData<ApiResponse> {
        if(refresh) { data = null }
        if (this.data == null) {
            data = apiEndPoint.getMostPopularNews(section, period)
            return data as LiveData<ApiResponse>
        }
        return data as LiveData<ApiResponse>
    }
}