package com.android.foodease.screens.dashboard

import com.android.foodease.app.CustomApp

class DashboardModel(private val app: CustomApp) {

    fun getLoggedInUser(username: String): String {
        return app.findUser(username)?.username ?: username
    }
}
