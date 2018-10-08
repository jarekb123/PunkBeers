package com.butajlo.punkbeers.screens.model

import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleViewModel

fun BeerEntity.toVM() = BeerSimpleViewModel(name, tagLine, imageUrl, abv, ibu, targetOg)