package com.recar.CarRent.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recar.CarRent.R

class AdapterCarParkPlace() :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val VIEWTYPE_IMAGE = 1
    val VIEWTYPE_TEXT = 2

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when (viewType) {
            VIEWTYPE_TEXT -> {
                val imageView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_more_car_park, parent, false)
                ViewHolder(imageView)
            }
            else -> {
                val imageView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_car_park_place, parent, false)
                ViewHolder(imageView)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            3 -> VIEWTYPE_TEXT
            else -> VIEWTYPE_IMAGE
        }

    }

    override fun getItemCount() = 4


}