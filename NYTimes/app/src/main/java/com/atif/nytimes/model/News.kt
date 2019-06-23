package com.atif.nytimes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class News(
    @SerializedName("byline")
    val byline: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("published_date")
    val published_date: String? = null,
    @SerializedName("abstract")
    val abstract: String? = null
): Serializable
