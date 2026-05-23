package com.android.foodease.screens.forgotpassword

import com.android.foodease.app.CustomApp

class ForgotPasswordModel(private val app: CustomApp) {

    fun retrievePassword(username: String): String? {
        return app.findUser(username)?.password
    }
}
