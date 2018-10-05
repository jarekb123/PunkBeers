package com.butajlo.punkbeers.mappers

interface Mapper<I, O> {
    fun I.map(): O
}