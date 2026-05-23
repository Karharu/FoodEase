package com.android.foodease.screens.dashboard

import com.android.foodease.common.data.Food

interface DashboardView {
    fun showWelcomeMessage(username: String)
    fun displayFoods(foodList: ArrayList<Food>)
    fun showMessage(message: String)
}

interface DashboardPresenterContract {
    fun onViewReady(username: String)
    fun addFood(foodName: String)
    fun removeFood(position: Int)
    fun getFoods(): ArrayList<Food>
}
