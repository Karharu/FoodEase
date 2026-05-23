package com.android.foodease.common.data

data class User(
    val username: String,
    val password: String
)
data class UserProfile(
    val username: String,
    val subtitle: String,
    val email: String,
    val phone: String,
    val location: String,
    val visits: Int,
    val reviews: Int,
    val favorites: Int
)
