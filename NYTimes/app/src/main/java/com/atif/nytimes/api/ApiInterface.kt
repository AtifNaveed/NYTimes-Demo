package com.atif.nytimes.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("mostpopular/v2/mostviewed/{section}/{period}.json")
    fun getData(
        @Path("section") section: String,
        @Path("period") period: String,
        @Query("api-key") apiKey: String
    ): Call<ApiResponse>
}
