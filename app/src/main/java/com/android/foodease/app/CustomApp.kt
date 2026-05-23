package com.android.foodease.app

import android.app.Application
import android.util.Log
import com.android.foodease.common.data.User

class CustomApp : Application() {

    private val registeredUsers = mutableListOf(
        User(username = "test", password = "1111")
    )

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Application started")
    }

    fun findUser(username: String): User? {
        return registeredUsers.find {
            it.username.equals(username, ignoreCase = true)
        }
    }

    fun isUsernameTaken(username: String): Boolean {
        return findUser(username) != null
    }

    fun registerUser(user: User) {
        registeredUsers.add(user)
    }

    companion object {
        private const val TAG = "CustomApp"
    }
}
