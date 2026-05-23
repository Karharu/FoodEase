package com.android.foodease.screens.dashboard

import com.android.foodease.common.data.Food

class DashboardPresenter(
    private val view: DashboardView,
    private val model: DashboardModel
) : DashboardPresenterContract {

    override fun onViewReady(username: String) {
        val displayName = model.getLoggedInUser(username)
        view.showWelcomeMessage(displayName)
        view.displayFoods(model.getFoods())
    }

    override fun addFood(foodName: String) {
        if (foodName.isNotBlank()) {
            model.addFood(foodName)
            view.displayFoods(model.getFoods())
        } else {
            view.showMessage("Please enter a food item")
        }
    }

    override fun removeFood(position: Int) {
        model.removeFood(position)
        view.displayFoods(model.getFoods())
    }

    override fun getFoods(): ArrayList<Food> {
        return model.getFoods()
    }
}
