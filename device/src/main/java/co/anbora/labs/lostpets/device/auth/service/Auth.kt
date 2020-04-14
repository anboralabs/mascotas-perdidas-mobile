package co.anbora.labs.lostpets.device.auth.service

import co.anbora.labs.lostpets.device.auth.controller.AuthController

interface Auth {

    fun loginRequest()

    fun login(controller: AuthController) {
        controller.login()
    }

}