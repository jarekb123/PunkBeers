package com.butajlo.punkbeers.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.base.BaseFragment
import com.butajlo.punkbeers.databinding.ScreenDetailsBinding
import kotlinx.android.synthetic.main.screen_details.*
import javax.inject.Inject

class DetailsFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var hopsAdapter: HopsAdapter

    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: ScreenDetailsBinding

    override fun layoutRes() = R.layout.screen_details

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutRes(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory)[DetailsViewModel::class.java]
        initHopsRecyclerView()
        initViewModelObservers()

        viewModel.getDetails(arguments?.getLong(ARGUMENT_BEER_ID) ?: return)
    }

    private fun initViewModelObservers() {
        viewModel.detailsLiveData.observe(this, Observer(::updateDetails))
    }

    private fun initHopsRecyclerView() {
        rv_hops_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = hopsAdapter
        }
    }


    private fun updateDetails(details: BeerDetailsModel?) {
        binding.model = details ?: return
    }

    companion object {
        const val ARGUMENT_BEER_ID = "ARGUMENT_BEER_ID"

        fun create(beerId: Long) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putLong(ARGUMENT_BEER_ID, beerId)
            }
        }
    }

}