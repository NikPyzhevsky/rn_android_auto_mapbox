package com.awesomemapboxproject;

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session


class CarAppSession : Session() {

    override fun onCreateScreen(intent: Intent): Screen {
        return PlaceListScreen(carContext)
    }

}
