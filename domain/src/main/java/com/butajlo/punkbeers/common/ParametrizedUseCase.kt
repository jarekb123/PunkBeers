package com.butajlo.punkbeers.common

interface ParametrizedUseCase<P, R> {
    fun execute(params: P): R
}