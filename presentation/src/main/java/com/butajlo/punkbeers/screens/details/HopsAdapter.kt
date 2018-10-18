package com.butajlo.punkbeers.screens.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.databinding.ItemGeneralHopsBinding
import com.butajlo.punkbeers.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class HopsAdapter @Inject constructor() : RecyclerView.Adapter<HopsAdapter.HopsViewHolder>() {

    private val data = mutableListOf<HopsModel>()

    fun addAll(newData: List<HopsModel>) {
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HopsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemGeneralHopsBinding>(inflater, R.layout.item_general_hops, parent, false)

        return HopsViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: HopsViewHolder, position: Int) = viewHolder.bind(data[position])


    inner class HopsViewHolder(private val binding: ItemGeneralHopsBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: HopsModel) {
            binding.hopsData = data
        }
    }
}