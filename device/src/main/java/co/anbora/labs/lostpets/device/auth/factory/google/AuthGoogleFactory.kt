package co.anbora.labs.lostpets.device.auth.factory.google

import android.app.Activity
import co.anbora.labs.lostpets.device.auth.behavior.AuthBehavior
import co.anbora.labs.lostpets.device.auth.controller.AuthController
import co.anbora.labs.lostpets.device.auth.controller.google.GoogleAuthController
import co.anbora.labs.lostpets.device.auth.factory.AuthFactory
import co.anbora.labs.lostpets.device.auth.model.ActivityResult
import co.anbora.labs.lostpets.device.auth.service.Auth
import co.anbora.labs.lostpets.device.auth.service.google.AuthGoogle

class AuthGoogleFactory : AuthFactory {

    private val authBehavior: AuthBehavior
    private val context: Activity
    private val defaultWebClientId: String

    constructor(context: Activity, defaultWebClientId: String, authBehavior: AuthBehavior) {

        this.context = context
        this.defaultWebClientId = defaultWebClientId
        this.authBehavior = authBehavior
    }

    override fun getAuthService(): Auth {
        return AuthGoogle(context, defaultWebClientId)
    }

    override fun getAuthController(activityResult: ActivityResult): AuthController {
        return GoogleAuthController(activityResult, this.authBehavior)
    }
}
