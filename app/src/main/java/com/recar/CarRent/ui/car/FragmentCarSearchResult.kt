package com.recar.CarRent.ui.car

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recar.CarRent.R
import com.recar.CarRent.common.AdapterCar


class FragmentCarSearchResult : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recCar).apply {
            adapter = AdapterCar() {
                goToCarDetailView()
            }
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        }
    }


    private fun goToCarDetailView() {
        val detailIntent = Intent(requireActivity(), ActivityCarDetail::class.java)
        startActivity(detailIntent)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentCarSearchResult()

    }
}