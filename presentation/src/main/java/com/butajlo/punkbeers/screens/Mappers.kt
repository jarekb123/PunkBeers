package com.butajlo.punkbeers.screens

import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleModel

fun BeerEntity.toVM() = BeerSimpleModel(name, tagLine, imageUrl, abv, ibu, targetOg)