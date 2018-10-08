package com.butajlo.punkbeers.screens.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.butajlo.punkbeers.screens.model.toVM
import com.butajlo.punkbeers.usecase.GetRandomBeerUseCase
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeFragmentViewModel(private val getRandomBeerUseCase: GetRandomBeerUseCase) : ViewModel() {

    val randomBeer = MutableLiveData<BeerSimpleViewModel>()

    fun updateRandomBeer() {
        getRandomBeerUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    randomBeer.value = it.toVM()
                }.dispose()
    }

}