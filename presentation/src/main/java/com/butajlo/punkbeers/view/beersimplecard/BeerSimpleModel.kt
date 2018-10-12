package com.butajlo.punkbeers.view.beersimplecard

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

data class BeerSimpleModel(
        val id: Long,
        val name: String,
        val tagLine: String,
        val imageUrl: String,
        val abv: Float,
        val ibu: Float,
        val og: Float
) {
    companion object {

        @JvmStatic
        @BindingAdapter("android:src", requireAll = true)
        fun loadImage(iv: ImageView, imageUrl: String?) {
            imageUrl ?: return
            Picasso.get()
                    .load(imageUrl)
                    .into(iv)
        }
    }
}