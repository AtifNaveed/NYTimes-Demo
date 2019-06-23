package com.atif.nytimes.api

import com.atif.nytimes.BuildConfig
import com.atif.nytimes.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiClient{

    private var retrofit : Retrofit? = null
    private var logging = HttpLoggingInterceptor()

    private fun getHttpLogClient(): OkHttpClient {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(Constant.request_timeout.toLong(), TimeUnit.SECONDS)
            .readTimeout(Constant.request_timeout.toLong(), TimeUnit.SECONDS)
            .writeTimeout(Constant.request_timeout.toLong(), TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        }
        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constant.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpLogClient())
                .build()
        }
        return retrofit
    }
}
