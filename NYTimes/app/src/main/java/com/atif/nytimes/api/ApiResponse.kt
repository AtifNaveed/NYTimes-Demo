package com.atif.nytimes.api

import com.atif.nytimes.model.News
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("num_results")
    val num_results: String? = null,
    @SerializedName("results")
    val results: ArrayList<News>)  {

    fun getNewsArray(): ArrayList<News> {
        return results
    }
}
