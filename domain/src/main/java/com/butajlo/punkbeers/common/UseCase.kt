package com.butajlo.punkbeers.common

interface UseCase<Params, Result> {

    fun execute(params: Params? = null): Result

}
