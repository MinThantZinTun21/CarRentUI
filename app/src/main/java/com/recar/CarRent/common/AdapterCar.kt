package com.recar.CarRent.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recar.CarRent.R

class AdapterCar(private val onItemClick: () -> Unit) :
    RecyclerView.Adapter<AdapterCar.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick()
        }
    }

    override fun getItemCount() = 20
}