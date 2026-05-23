package com.android.foodease.screens.profile

import com.android.foodease.app.CustomApp
import com.android.foodease.common.data.UserProfile

class ProfileModel(private val app: CustomApp) {
    fun getProfile(): UserProfile {
        return UserProfile(
            username = "Kianne Macabale",
            subtitle = "Food Explorer",
            email = "kianne.macabale@cit.edu",
            phone = "+1 (555) 123-4567",
            location = "Labangon, Cebu City",
            visits = 127,
            reviews = 34,
            favorites = 12
        )
    }

    fun logout() {
        app.clearSession()
    }
}