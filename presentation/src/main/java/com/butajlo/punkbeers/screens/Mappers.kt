package com.butajlo.punkbeers.screens

import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.model.HopsEntity
import com.butajlo.punkbeers.screens.details.BeerDetailsModel
import com.butajlo.punkbeers.screens.details.HopsModel
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleModel


fun BeerEntity.toVM() = BeerSimpleModel(id, name, tagLine, imageUrl, abv, ibu, targetOg)

fun BeerEntity.toDetailsVM() = BeerDetailsModel(name, tagLine, description, firstBrewed, hops.map { it.toVM() })

fun HopsEntity.toVM() = HopsModel(name, amount, amountUnit, addTime)