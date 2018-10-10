package com.butajlo.punkbeers.common

interface UseCase<Result> {

    fun execute(): Result

}
