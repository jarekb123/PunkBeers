package com.butajlo.punkbeers.screens.details

data class BeerDetailsModel(
        val name: String,
        val tagLine: String,
        val description: String,
        val firstBrewed: String,
        val hops: List<HopsModel>
)