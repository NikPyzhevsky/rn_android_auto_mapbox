package com.awesomemapboxproject;

import androidx.car.app.CarAppService
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator
import androidx.annotation.NonNull

class MyCarAppService : CarAppService() {
    @NonNull
    override fun createHostValidator(): HostValidator {
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    }

    override fun onCreateSession(): Session {
        return CarAppSession()
    }

}
