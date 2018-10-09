package com.butajlo.punkbeers.executor

import com.butajlo.punkbeers.common.UseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Singleton

@Singleton
class UseCaseExecutor(private val ioScheduler: Scheduler,
                      private val uiScheduler: Scheduler) {

    fun <Params, Result> async(useCase: UseCase<Params, Observable<Result>>, params: Params? = null)
            : Builder<Params, Result> where Result : Any {
        return Builder(useCase, params, ioScheduler, uiScheduler)
    }

    class Builder<Params, Result>(
            private val useCase: UseCase<Params, Observable<Result>>,
            private val params: Params? = null,
            private val ioScheduler: Scheduler,
            private val uiScheduler: Scheduler) where Result : Any {

        fun execute(onSuccess: (Result) -> Unit, onError: (Throwable) -> Unit) : Disposable =
            useCase.execute(params)
                    .subscribeOn(ioScheduler)
                    .observeOn(uiScheduler)
                    .subscribeBy(
                            onNext = onSuccess,
                            onError = onError
                    )

    }

}