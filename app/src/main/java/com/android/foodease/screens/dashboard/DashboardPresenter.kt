package com.android.foodease.screens.dashboard

import com.android.foodease.common.data.Food

class DashboardPresenter(
    private val view: DashboardView,
    private val model: DashboardModel
) : DashboardPresenterContract {

    override fun onViewReady(username: String) {
        val displayName = model.getLoggedInUser(username)
        view.showWelcomeMessage(displayName)
        view.displayTrending(model.getTrendingFoods())
        view.displayNearby(model.getNearbySpots())
    }

    override fun getTrendingFoods(): ArrayList<Food> {
        return model.getTrendingFoods()
    }

    override fun getNearbySpots(): ArrayList<Food> {
        return model.getNearbySpots()
    }
}
