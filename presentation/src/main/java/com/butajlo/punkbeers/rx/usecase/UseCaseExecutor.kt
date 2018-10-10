package com.butajlo.punkbeers.rx.usecase

import com.butajlo.punkbeers.common.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Singleton

@Singleton
class UseCaseExecutor(private val ioScheduler: Scheduler,
                      private val uiScheduler: Scheduler) {

    fun <Result> async(useCase: UseCase<Single<Result>>)
            : Builder<Result> where Result : Any {
        return Builder(useCase, ioScheduler, uiScheduler)
    }

    class Builder<Result>(
            private val useCase: UseCase<Single<Result>>,
            private val ioScheduler: Scheduler,
            private val uiScheduler: Scheduler) where Result : Any {

        fun execute(onSuccess: (Result) -> Unit, onError: (Throwable) -> Unit) : Disposable =
            useCase.execute()
                    .subscribeOn(ioScheduler)
                    .observeOn(uiScheduler)
                    .subscribeBy(
                            onSuccess = onSuccess,
                            onError = onError
                    )

    }

}