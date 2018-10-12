package com.butajlo.punkbeers.screens.details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.base.BaseFragment
import com.butajlo.punkbeers.databinding.ScreenDetailsBinding
import javax.inject.Inject

class DetailsFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: DetailsViewModel

    override fun layoutRes() = R.layout.screen_details

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[DetailsViewModel::class.java]
        val binding = ScreenDetailsBinding.inflate(layoutInflater)
        viewModel.detailsLiveData.observe(this, Observer { binding.model = it })

        viewModel.getDetails(arguments.getLong(ARGUMENT_BEER_ID))
    }

    companion object {
        private const val ARGUMENT_BEER_ID = "ARGUMENT_BEER_ID"

        fun create(beerId: Long) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putLong(ARGUMENT_BEER_ID, beerId)
            }
        }
    }

}