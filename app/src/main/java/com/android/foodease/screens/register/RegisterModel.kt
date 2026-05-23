package com.android.foodease.screens.register

import com.android.foodease.app.CustomApp
import com.android.foodease.common.data.User

class RegisterModel(private val app: CustomApp) {

    fun isUsernameTaken(username: String): Boolean {
        return app.isUsernameTaken(username)
    }

    fun saveUser(username: String, password: String) {
        app.registerUser(User(username = username, password = password))
    }
}
