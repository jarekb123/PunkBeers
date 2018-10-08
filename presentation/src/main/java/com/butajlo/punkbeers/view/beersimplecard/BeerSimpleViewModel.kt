package com.butajlo.punkbeers.view.beersimplecard

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

data class BeerSimpleViewModel(
        val name: String,
        val tagLine: String,
        val imageUrl: String,
        val abv: Float,
        val ibu: Float,
        val og: Float
) {
    companion object {

        @JvmStatic
        @BindingAdapter("app:imageUrl", requireAll = true)
        fun loadImage(iv: ImageView, imageUrl: String?) {
            imageUrl ?: return
            Picasso.get()
                    .load(imageUrl)
                    .into(iv)
        }
    }
}