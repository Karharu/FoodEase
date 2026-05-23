package com.android.foodease.screens.login

import com.android.foodease.app.CustomApp

class LoginModel(private val app: CustomApp) {

    fun isValidCredential(username: String, password: String): Boolean {
        val user = app.findUser(username) ?: return false
        return user.password.equals(password, ignoreCase = false)
    }
}
