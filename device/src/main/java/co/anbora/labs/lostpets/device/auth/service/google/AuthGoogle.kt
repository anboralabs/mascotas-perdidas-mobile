package co.anbora.labs.lostpets.device.auth.service.google

import android.app.Activity
import co.anbora.labs.lostpets.device.auth.AuthEnum
import co.anbora.labs.lostpets.device.auth.service.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class AuthGoogle : Auth {

    private val context: Activity

    //Google Sign In Client
    private val mGoogleSignInClient: GoogleSignInClient

    constructor(context: Activity, defaultWebClientId: String) {
        this.context = context

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(defaultWebClientId)
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this.context, gso)
    }

    override fun loginRequest() {
        val signInIntent = mGoogleSignInClient.signInIntent
        context.startActivityForResult(signInIntent, AuthEnum.GOOGLE.authValue)
    }
}