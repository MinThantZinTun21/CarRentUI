package com.recar.CarRent.component

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.RawRes
import androidx.lifecycle.Transformations.map
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import com.recar.CarRent.R
import com.recar.CarRent.common.*


class GoGetMap(private val context: Context, private val mMap: GoogleMap) {

    init {
        setupMapView()
        mMap.uiSettings.isCompassEnabled = false
        mMap.uiSettings.isMapToolbarEnabled = false
        setMapStyle(R.raw.map_style_standard)


    }


    fun showMarkerWithBond() {
        val markersList = showMarkers()
        //  setMapViewBond(markersList)
    }

    private fun setupMapView() {
        val cameraPosition = CameraPosition.Builder()
            .zoom(VALUE_MAP_ZOOM)
            .target(MOCK_LATLONG)
            .tilt(VALUE_MAP_TILE_COUNT)
            .build()
        mMap.animateCamera(
            CameraUpdateFactory.newCameraPosition(cameraPosition)
        )
    }

    private fun setMapStyle(@RawRes styleResource: Int) {
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, styleResource))

    }
     fun showMarker() {
        val customerMarker =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.item_custom_marker_car,
                null
            )
        mMap.addMarker(
            MarkerOptions().position(MOCK_LATLONG)
                .icon(
                    BitmapDescriptorFactory.fromBitmap(
                        getBitmapMarkerFromView(
                            customerMarker,
                        )
                    )
                )
        )
    }

    private fun showMarkers(): List<Marker> {
        val customerMarker =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.view_go_get_marker,
                null
            )
        return getDummyLatLongList().map {
            var randonCar = ((System.nanoTime() * System.nanoTime()) % 10)
            val count = Math.abs(randonCar)
            val tvCount = customerMarker.findViewById<TextView>(R.id.tvCarCount)
            tvCount.text = count.toString()
            val marker = mMap.addMarker(
                MarkerOptions().position(it)
                    .icon(
                        BitmapDescriptorFactory.fromBitmap(
                            getBitmapMarkerFromView(
                                customerMarker,
                            )
                        )
                    )
            )
            marker
        }.toList()
    }


    private fun setMapViewBond(markersList: List<Marker>) {
        val latLongBuilder: LatLngBounds.Builder = LatLngBounds.builder()
        markersList.map {
            latLongBuilder.include(it.position)
        }
        val cameraPosition = CameraPosition.Builder()
            .zoom(VALUE_MAP_ZOOM)
            .target(LatLng(16.7588579, 96.2223808))
            .tilt(VALUE_MAP_TILE_COUNT)
            .build()
        mMap.animateCamera(
            CameraUpdateFactory.newCameraPosition(cameraPosition)
        )
    }

    private fun getBitmapMarkerFromView(view: View): Bitmap {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.buildDrawingCache()
        val returnedBitmap = Bitmap.createBitmap(
            view.measuredWidth, view.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(returnedBitmap)
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN)
        val drawable = view.background
        drawable?.draw(canvas)
        view.draw(canvas)
        return returnedBitmap
    }

    fun drawCircle() {
        mMap.addCircle(
            CircleOptions()
                .center(MOCK_LATLONG)
                .radius(32.0)
                .strokeColor(Color.TRANSPARENT)
                .fillColor(context.getColor(R.color.color_grey_transparent_90))
        )
        mMap.addCircle(
            CircleOptions()
                .center(MOCK_LATLONG)
                .radius(6.0)
                .strokeWidth(3f)
                .strokeColor(Color.WHITE)
                .fillColor(context.getColor(R.color.pink_500))
        )
    }
}