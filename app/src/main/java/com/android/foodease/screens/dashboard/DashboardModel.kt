package com.android.foodease.screens.dashboard

import com.android.foodease.app.CustomApp
import com.android.foodease.common.data.Food

class DashboardModel(private val app: CustomApp) {

    private val foods = arrayListOf(
        Food("Burger", "Fast Food", android.R.drawable.ic_menu_camera),
        Food("Pizza", "Italian", android.R.drawable.ic_menu_compass),
        Food("Fries", "Side Dish", android.R.drawable.ic_menu_gallery)
    )

    fun getLoggedInUser(username: String): String {
        return app.findUser(username)?.username ?: username
    }

    fun getFoods(): ArrayList<Food> {
        return foods
    }

    fun addFood(foodName: String) {
        foods.add(Food(foodName, "Custom", android.R.drawable.ic_menu_slideshow))
    }

    fun removeFood(position: Int) {
        if (position in foods.indices) {
            foods.removeAt(position)
        }
    }
}
