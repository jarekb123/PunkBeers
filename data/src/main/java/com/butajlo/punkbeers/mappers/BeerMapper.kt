package com.butajlo.punkbeers.mappers

import com.butajlo.punkbeers.model.Beer
import com.butajlo.punkbeers.model.BeerEntity

fun BeerEntity.map() = Beer(id, name)
