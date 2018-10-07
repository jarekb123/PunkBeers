package com.butajlo.punkbeers.data.model

import com.google.gson.annotations.SerializedName

data class Beer(
        val id: Long,
        val name: String,
        val description: String,
        @SerializedName("image_url") val imageUrl: String
)