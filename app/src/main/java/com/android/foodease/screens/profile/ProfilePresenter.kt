package com.android.foodease.screens.profile

import com.android.foodease.app.CustomApp

class ProfilePresenter(
    private var view: ProfileContract.View?,
    private val model: ProfileModel
) : ProfileContract.Presenter {

    override fun loadProfile() {
        val profile = model.getProfile()
        view?.showUserName(profile.username)
        view?.showUserInitial(profile.username.first().uppercase())
        view?.showStats(profile.visits, profile.reviews, profile.favorites)
        view?.showEmail(profile.email)
        view?.showPhone(profile.phone)
        view?.showLocation(profile.location)
    }

    override fun onLogoutClicked() {
        model.logout()
        view?.navigateToLogin()
    }

    override fun onBackClicked() {
        view?.navigateBack()
    }

    override fun onDestroy() {
        view = null
    }
}