package com.butajlo.punkbeers.coroutines

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.map

fun <T, E> CoroutineScope.asyncLoad(job: Job,
                                    loadFunction: () -> T,
                                    uiFunction: (T) -> Unit,
                                    errorFunction: (E : Throwable) -> Unit) where E : Throwable {

    actor<Unit>(context = Dispatchers.Main + job) {
        channel.map(Dispatchers.Default) {
            loadFunction()
        }.consumeEach {
            try {
                uiFunction(it)
            } catch (t: Throwable) {
                errorFunction(t)
            }
        }
    }

}