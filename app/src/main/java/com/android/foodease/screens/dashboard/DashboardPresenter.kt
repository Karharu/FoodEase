package com.android.foodease.screens.dashboard

class DashboardPresenter(
    private val view: DashboardView,
    private val model: DashboardModel
) : DashboardPresenterContract {

    override fun onViewReady(username: String) {
        val displayName = model.getLoggedInUser(username)
        view.showWelcomeMessage(displayName)
    }
}
