package com.butajlo.punkbeers.screens.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.rx.usecase.UseCaseExecutor
import com.butajlo.punkbeers.screens.toDetailsVM
import com.butajlo.punkbeers.usecase.GetBeerUseCase
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val getBeerUseCase: GetBeerUseCase,
                                           private val executor: UseCaseExecutor,
                                           private val hopsAdapter: HopsAdapter)
    : ViewModel() {

    val detailsLiveData = MutableLiveData<BeerDetailsModel>()
    val hopsLiveData = MutableLiveData<List<HopsModel>>()

    val loadingLiveData = MutableLiveData<Boolean>()
    val errorResLiveData = MutableLiveData<Int>()

    fun getDetails(beerId: Long) {
        executor.async(getBeerUseCase)
                .execute(
                        params = beerId,
                        onSuccess = { updateDetails(it.toDetailsVM()) },
                        onError = ::updateError)
    }

    private fun updateDetails(detailsModel: BeerDetailsModel) {
        detailsLiveData.value = detailsModel
        loadingLiveData.value = false
        hopsAdapter.addAll(detailsModel.hops)
    }


    private fun updateError(error: Throwable) {
        Log.e(javaClass.simpleName, "Error during loading Beer Details", error)
        errorResLiveData.value = R.string.details_loading_data_error
    }

}