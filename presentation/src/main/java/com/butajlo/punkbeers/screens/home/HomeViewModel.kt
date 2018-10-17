package com.butajlo.punkbeers.screens.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.butajlo.punkbeers.navigator.Navigator
import com.butajlo.punkbeers.rx.usecase.UseCaseExecutor
import com.butajlo.punkbeers.screens.toVM
import com.butajlo.punkbeers.usecase.GetRandomBeerUseCase
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getRandomBeerUseCase: GetRandomBeerUseCase,
                                        private val executor: UseCaseExecutor,
                                        private val navigator: Navigator)
    : ViewModel() {

    val randomBeer = MutableLiveData<BeerSimpleModel>()

    private val subscriptions = CompositeDisposable()

    init {
        updateRandomBeer()
    }

    override fun onCleared() {
        subscriptions.clear()
    }

    fun updateRandomBeer() {
        executor.async(getRandomBeerUseCase)
                .execute(onSuccess = { randomBeer.value = it.toVM() }, onError = {
                    Log.e(javaClass.simpleName, "updateRandomBeer error", it)
                })
    }

    fun goToBeerDetails(beerId: Long) {
        navigator.goToBeerDetails(beerId)
    }

}