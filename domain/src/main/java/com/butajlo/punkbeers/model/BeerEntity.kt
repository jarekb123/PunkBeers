package com.butajlo.punkbeers.model

data class BeerEntity(
        val id: Long,
        val name: String,
        val description: String,
        val imageUrl: String,
        val tagLine: String,
        val abv: Float,
        val ibu: Float,
        val targetOg: Float
)