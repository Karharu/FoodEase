package com.android.foodease.screens.dashboard

import com.android.foodease.common.data.Food

interface DashboardView {
    fun showWelcomeMessage(username: String)
    fun displayTrending(trendingFoods: ArrayList<Food>)
    fun displayNearby(nearbySpots: ArrayList<Food>)
    fun showMessage(message: String)
}

interface DashboardPresenterContract {
    fun onViewReady(username: String)
    fun getTrendingFoods(): ArrayList<Food>
    fun getNearbySpots(): ArrayList<Food>
}
