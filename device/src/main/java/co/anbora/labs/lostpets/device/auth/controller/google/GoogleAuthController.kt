package co.anbora.labs.lostpets.device.auth.controller.google

import android.app.Activity
import android.content.Intent
import co.anbora.labs.lostpets.device.auth.AuthEnum
import co.anbora.labs.lostpets.device.auth.behavior.AuthBehavior
import co.anbora.labs.lostpets.device.auth.controller.AuthController
import co.anbora.labs.lostpets.device.auth.model.ActivityResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

class GoogleAuthController: AuthController {

    private val requestCode: Int
    private val data: Intent
    private val context: Activity

    private val authBehavior: AuthBehavior

    constructor(activityResult: ActivityResult,
                authBehavior: AuthBehavior) {

        this.context = activityResult.context
        this.requestCode = activityResult.requestCode
        this.data = activityResult.data
        this.authBehavior = authBehavior
    }

    override fun login() {
        if (this.requestCode == AuthEnum.GOOGLE.authValue) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                this.authBehavior.onLoginComplete(GoogleAuthProvider.getCredential(account?.idToken, null))
            } catch (e: ApiException) {
                this.authBehavior.onLoginError()
            }
        }
    }
}
