package com.butajlo.punkbeers.screens.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.base.BaseFragment
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleModel
import kotlinx.android.synthetic.main.screen_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    override fun layoutRes(): Int = R.layout.screen_home

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[HomeFragmentViewModel::class.java]
        viewModel.randomBeer.observe(this, Observer(::updateRandomBeer))
        viewModel.updateRandomBeer()
    }

    private fun updateRandomBeer(beer: BeerSimpleModel?) {
        beer_card_random.setViewModel(beer ?: return)
        beer_card_random.visibility = View.VISIBLE
        beer_card_random.setOnClickListener { viewModel.goToBeerDetails(beer.id) }
    }

}