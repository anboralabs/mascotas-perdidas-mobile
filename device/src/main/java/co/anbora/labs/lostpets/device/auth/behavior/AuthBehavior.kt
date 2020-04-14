package co.anbora.labs.lostpets.device.auth.behavior

import com.google.firebase.auth.AuthCredential

interface AuthBehavior {

    fun onLoginComplete(credential: AuthCredential)

    fun onLoginError()

}
