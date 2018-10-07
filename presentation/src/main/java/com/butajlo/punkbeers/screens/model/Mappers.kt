package com.butajlo.punkbeers.screens.model

import com.butajlo.punkbeers.model.BeerEntity

fun BeerEntity.toVM() = BeerSimpleViewModel(name, tagLine, imageUrl, abv, ibu, targetOg)