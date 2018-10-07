package com.butajlo.punkbeers.screens.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class HomeFragmentViewModel : ViewModel() {

    val beerName = MutableLiveData<String>()
    val beerTagLine = MutableLiveData<String>()

}