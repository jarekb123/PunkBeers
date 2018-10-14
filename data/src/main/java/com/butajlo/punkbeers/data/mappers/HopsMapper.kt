package com.butajlo.punkbeers.data.mappers

import com.butajlo.punkbeers.data.model.Hops
import com.butajlo.punkbeers.model.HopsEntity

fun Hops.toDomainModel() = HopsEntity(name, amount.value, amount.unit, add, attribute)