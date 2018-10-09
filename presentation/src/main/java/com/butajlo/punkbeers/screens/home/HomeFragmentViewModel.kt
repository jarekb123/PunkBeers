package com.butajlo.punkbeers.screens.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.butajlo.punkbeers.executor.GetRandomBeerUseCase
import com.butajlo.punkbeers.executor.UseCaseExecutor
import com.butajlo.punkbeers.screens.model.toVM
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(private val getRandomBeerUseCase: GetRandomBeerUseCase,
                                                private val executor: UseCaseExecutor)
    : ViewModel() {

    val randomBeer = MutableLiveData<BeerSimpleViewModel>()

    private val subscriptions = CompositeDisposable()

    fun updateRandomBeer() {
        executor.async(getRandomBeerUseCase)
                .execute(onSuccess = { randomBeer.value = it.toVM() }, onError = {})
    }

    override fun onCleared() {
        subscriptions.clear()
    }

}