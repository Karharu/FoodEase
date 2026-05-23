package com.android.foodease.screens.dashboard

import com.android.foodease.app.CustomApp
import com.android.foodease.common.data.Food

class DashboardModel(private val app: CustomApp) {

    private val trendingFoods = arrayListOf(
        Food(
            foodName = "Gourmet Burger",
            subtitle = "The Burger House",
            price = "$12.99",
            rating = "4.8",
            reviews = "120",
            distance = "",
            imageRes = android.R.drawable.ic_menu_camera
        ),
        Food(
            foodName = "Spicy Ramen",
            subtitle = "Tokyo Kitchen",
            price = "$14.50",
            rating = "4.6",
            reviews = "98",
            distance = "",
            imageRes = android.R.drawable.ic_menu_gallery
        ),
        Food(
            foodName = "Classic Pasta",
            subtitle = "Pasta Point",
            price = "$11.20",
            rating = "4.7",
            reviews = "75",
            distance = "",
            imageRes = android.R.drawable.ic_menu_slideshow
        )
    )

    private val nearbySpots = arrayListOf(
        Food(
            foodName = "The Burger House",
            subtitle = "American",
            price = "0.3 km",
            rating = "4.8",
            reviews = "234 reviews",
            distance = "",
            imageRes = android.R.drawable.ic_menu_compass
        ),
        Food(
            foodName = "Tokyo Kitchen",
            subtitle = "Japanese",
            price = "0.5 km",
            rating = "4.9",
            reviews = "198 reviews",
            distance = "",
            imageRes = android.R.drawable.ic_menu_gallery
        )
    )

    fun getLoggedInUser(username: String): String {
        return app.findUser(username)?.username ?: username
    }

    fun getTrendingFoods(): ArrayList<Food> = trendingFoods

    fun getNearbySpots(): ArrayList<Food> = nearbySpots
}
