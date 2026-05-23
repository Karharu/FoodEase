package com.android.foodease.screens.dashboard

interface DashboardView {
    fun showWelcomeMessage(username: String)
}

interface DashboardPresenterContract {
    fun onViewReady(username: String)
}
