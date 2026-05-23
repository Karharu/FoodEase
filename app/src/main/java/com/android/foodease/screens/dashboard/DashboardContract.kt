package com.android.foodease.screens.dashboard

interface DashboardView {
    fun showWelcomeMessage(username: String)
    fun showLogoutSuccess()
    fun navigateToLogin()
}

interface DashboardPresenterContract {
    fun onViewReady(username: String)
    fun onLogoutClicked()
}
