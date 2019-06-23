package com.atif.nytimes.utils
import com.atif.nytimes.BuildConfig

class Constant {
    companion object {
        const val request_timeout = 30
        const val base_url = BuildConfig.base_url
        const val api_key = BuildConfig.api_key
        const val new_object_key = "news_object"
        const val news_list_key = "news_list_key"

        const val number_of_sections = "all-sections"
        const val period = "7"
    }
}
