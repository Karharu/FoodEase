package com.android.foodease.screens.profile

interface ProfileContract {

    interface View {
        fun showUserName(name: String)
        fun showUserInitial(initial: String)
        fun showStats(visits: Int, reviews: Int, favorites: Int)
        fun showEmail(email: String)
        fun showPhone(phone: String)
        fun showLocation(location: String)
        fun navigateToLogin()
        fun navigateBack()
    }

    interface Presenter {
        fun loadProfile()
        fun onLogoutClicked()
        fun onBackClicked()
        fun onDestroy()
    }
}