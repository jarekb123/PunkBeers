package com.butajlo.punkbeers.view.beersimplecard

data class BeerSimpleViewModel(
        val name: String,
        val tagLine: String,
        val imageUrl: String,
        val abv: Float,
        val ibu: Float,
        val og: Float
)