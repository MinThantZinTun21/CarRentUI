package com.recar.CarRent.common

import com.google.android.gms.maps.model.LatLng

const val VALUE_MAP_ZOOM = 17f
const val VALUE_MAP_TILE_COUNT = 20f
val MOCK_LATLONG = LatLng(16.877469, 96.1403462)
fun getDummyLatLongList(): ArrayList<LatLng> {
    val latlongList = arrayListOf<LatLng>(
        LatLng(16.879169, 96.1403462),
        LatLng(16.876169, 96.1403462),
        LatLng(16.876161, 96.1503452),
        LatLng(16.876162, 96.1413452),
        LatLng(16.876163, 96.1423452),
        LatLng(16.876134, 96.1423452),
        LatLng(16.874119, 96.1403462),
    )
    return latlongList
}