package com.butajlo.punkbeers.data.mappers

import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.data.model.Beer

fun Beer.toDomainModel() = BeerEntity(id, name)
