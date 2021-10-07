package com.recar.CarRent.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.recar.CarRent.R
import com.smarteist.autoimageslider.SliderViewAdapter

class AdapterCarImageSlider : SliderViewAdapter<AdapterCarImageSlider.ViewHolder>() {
    class ViewHolder(v: View) : SliderViewAdapter.ViewHolder(v) {


    }

    override fun getCount()=3

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_car_slider, null)
        return ViewHolder(view)
     }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
    }
}