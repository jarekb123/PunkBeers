package com.butajlo.punkbeers.rx.usecase

import com.butajlo.punkbeers.common.ParametrizedUseCase
import com.butajlo.punkbeers.common.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Singleton

@Singleton
class UseCaseExecutor(private val ioScheduler: Scheduler,
                      private val uiScheduler: Scheduler) {

    // UseCase async

    fun <Result> async(useCase: UseCase<Single<Result>>) where Result : Any
            = Builder(useCase, ioScheduler, uiScheduler)


    class Builder<Result>(
            private val useCase: UseCase<Single<Result>>,
            private val ioScheduler: Scheduler,
            private val uiScheduler: Scheduler) where Result : Any {

        fun execute(onSuccess: (Result) -> Unit, onError: (Throwable) -> Unit): Disposable =
                useCase.execute()
                        .subscribeOn(ioScheduler)
                        .observeOn(uiScheduler)
                        .subscribeBy(
                                onSuccess = onSuccess,
                                onError = onError
                        )

    }

    fun <P, R> async(parametrizedUseCase: ParametrizedUseCase<P, Single<R>>) where R : Any
            = ParametrizedBuilder(parametrizedUseCase, ioScheduler, uiScheduler)

    class ParametrizedBuilder<P, R>(private val useCase: ParametrizedUseCase<P, Single<R>>,
                                    private val ioScheduler: Scheduler,
                                    private val uiScheduler: Scheduler) where R : Any {

        fun execute(params: P, onSuccess: (R) -> Unit, onError: (Throwable) -> Unit): Disposable =
                useCase.execute(params)
                        .subscribeOn(ioScheduler)
                        .observeOn(uiScheduler)
                        .subscribeBy(
                                onSuccess = onSuccess,
                                onError = onError
                        )
    }

}