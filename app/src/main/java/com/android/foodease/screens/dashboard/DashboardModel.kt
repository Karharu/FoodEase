package com.android.foodease.screens.dashboard

import com.android.foodease.app.CustomApp
import com.android.foodease.common.data.Food

class DashboardModel(private val app: CustomApp) {

    private val foods = arrayListOf(
        Food("Burger"),
        Food("Pizza"),
        Food("Fries")
    )

    fun getLoggedInUser(username: String): String {
        return app.findUser(username)?.username ?: username
    }

    fun getFoods(): ArrayList<Food> {
        return foods
    }

    fun addFood(foodName: String) {
        foods.add(Food(foodName))
    }

    fun removeFood(position: Int) {
        if (position in foods.indices) {
            foods.removeAt(position)
        }
    }
}
