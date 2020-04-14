package co.anbora.labs.lostpets.device.auth.factory

import co.anbora.labs.lostpets.device.auth.controller.AuthController
import co.anbora.labs.lostpets.device.auth.model.ActivityResult
import co.anbora.labs.lostpets.device.auth.service.Auth

interface AuthFactory {

    fun getAuthService(): Auth

    fun getAuthController(activityResult: ActivityResult): AuthController

}