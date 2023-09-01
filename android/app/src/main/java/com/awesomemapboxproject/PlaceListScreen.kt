package com.awesomemapboxproject;

import android.location.Location
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*


class PlaceListScreen(carContext: CarContext)
    : Screen(carContext){

    private fun createDummyPlaceList(): List<Place> {
        val placeList = mutableListOf<Place>()

        // Добавление фиктивных данных мест в список
        placeList.add(Place("Место 1", "Адрес 1", 55.123, 37.456))
        placeList.add(Place("Место 2", "Адрес 2", 55.789, 37.123))
        placeList.add(Place("Место 3", "Адрес 3", 55.456, 37.789))

        return placeList
    }

    data class Place(val name: String, val address: String, val latitude: Double, val longitude: Double)

    override fun onGetTemplate(): Template {

        val listBuilder = ItemList.Builder()
        val placeList: List<Place> = createDummyPlaceList()


        placeList.forEach {

            val location = Location(PlaceListScreen::class.java.simpleName)
            location.latitude = it.latitude
            location.longitude = it.longitude

            listBuilder.addItem(
                Row.Builder()
                    .setTitle(it.name)
                    .addText(it.address)
//                .setMetadata(
//                    Metadata.Builder()
//                        .setPlace(getPlace(it))
//                        .build()
//                )
                    .setBrowsable(true)
                    .setOnClickListener {
                        onPlaceClick()
                    }
                    .build())

        }

        val builder = PlaceListMapTemplate.Builder()
            .setTitle("Nearby Parking")
            .setHeaderAction(Action.APP_ICON)
            .setCurrentLocationEnabled(false)

        return if (placeList.isEmpty()) {
            builder.setLoading(true).build()
        } else {
            builder.setItemList(listBuilder.build()).build()
        }
    }

    private fun onPlaceClick() {

    }
}