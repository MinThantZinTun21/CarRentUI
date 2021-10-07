package com.recar.CarRent.ui.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.SupportMapFragment
import com.recar.CarRent.R
import com.recar.CarRent.common.AdapterCarImageSlider
import com.recar.CarRent.common.AdapterCarParkPlace
import com.recar.CarRent.component.GoGetMap
import com.smarteist.autoimageslider.SliderView

class ActivityCarDetail : AppCompatActivity() {
    lateinit var slider: SliderView
    lateinit var getGoMap: GoGetMap
    lateinit var carParkPlace: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)
        setUpCarSlideAdapter()
        setUpCarParkPlace()
        loadGetGoMap()
    }

    private fun setUpCarSlideAdapter() {
        slider = findViewById(R.id.imageSlider)
        slider.setSliderAdapter(AdapterCarImageSlider())
    }

    private fun setUpCarParkPlace() {
        carParkPlace = findViewById(R.id.recCarParkPlace)
        carParkPlace.apply {
            adapter = AdapterCarParkPlace()
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }

    private fun loadGetGoMap() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { p0 ->
            p0?.let {
                getGoMap = GoGetMap(context = baseContext, it)
                getGoMap.showMarker()
            }
        }
    }
}