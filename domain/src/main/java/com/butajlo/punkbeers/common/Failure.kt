package com.butajlo.punkbeers.common

sealed class Failure {
    object NetworkConnectionFailure : Failure()
    object ServerError : Failure()


    abstract class FeatureFailure: Failure()
}