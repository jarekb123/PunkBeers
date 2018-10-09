package com.butajlo.punkbeers.executor

import com.butajlo.punkbeers.rx.SchedulersModule
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

@Module(includes = [SchedulersModule::class])
class UseCaseExecutorModule {

    @Provides
    fun provideUseCaseExecutor(@Named("io_scheduler") ioScheduler: Scheduler,
                               @Named("ui_scheduler") uiScheduler: Scheduler)
            = UseCaseExecutor(ioScheduler, uiScheduler)

}