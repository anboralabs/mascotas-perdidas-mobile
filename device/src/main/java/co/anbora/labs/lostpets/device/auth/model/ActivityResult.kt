package co.anbora.labs.lostpets.device.auth.model

import android.app.Activity
import android.content.Intent

data class ActivityResult(val context: Activity, val requestCode: Int, val resultCode: Int, val data: Intent)
