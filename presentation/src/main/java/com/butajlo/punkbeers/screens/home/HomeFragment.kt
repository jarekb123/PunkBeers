package com.butajlo.punkbeers.screens.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.base.BaseFragment
import com.butajlo.punkbeers.screens.details.DetailsFragment
import com.butajlo.punkbeers.view.beersimplecard.BeerSimpleModel
import kotlinx.android.synthetic.main.screen_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    override fun layoutRes(): Int = R.layout.screen_home

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]
        viewModel.randomBeer.observe(this, Observer(::updateRandomBeer))
    }

    private fun updateRandomBeer(beer: BeerSimpleModel?) {
        beer_card_random.setViewModel(beer ?: return)
        beer_card_random.visibility = View.VISIBLE
        beer_card_random.setOnClickListener { navigateToDetails(beer.id) }
    }

    private fun navigateToDetails(beerId: Long) {
        val beerDetailsBundle = bundleOf(DetailsFragment.ARGUMENT_BEER_ID to beerId)
        findNavController().navigate(R.id.home_to_details_action, beerDetailsBundle)
    }

}