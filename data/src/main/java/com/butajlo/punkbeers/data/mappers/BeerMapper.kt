package com.butajlo.punkbeers.data.mappers

import com.butajlo.punkbeers.data.model.Beer
import com.butajlo.punkbeers.model.BeerEntity

fun Beer.toDomainModel() = BeerEntity(id, name, description, imageUrl, tagline, abv, ibu, targetOg, firstBrewed, ingredients.hops.map { it.toDomainModel() })
