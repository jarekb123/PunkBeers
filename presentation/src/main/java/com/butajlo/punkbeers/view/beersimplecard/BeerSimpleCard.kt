package com.butajlo.punkbeers.view.beersimplecard

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.LayoutInflater
import com.butajlo.punkbeers.databinding.BeerSimpleCardBinding

class BeerSimpleCard : CardView {

    val binding: BeerSimpleCardBinding

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    init {
        val inflater = LayoutInflater.from(context)
        binding = BeerSimpleCardBinding.inflate(inflater, this, true)
    }

    fun setViewModel(viewModel: BeerSimpleModel) {
        binding.viewModel = viewModel
    }

}