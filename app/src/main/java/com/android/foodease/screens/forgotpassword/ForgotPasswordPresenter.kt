package com.android.foodease.screens.forgotpassword

class ForgotPasswordPresenter(
    private val view: ForgotPasswordView,
    private val model: ForgotPasswordModel
) : ForgotPasswordPresenterContract {

    override fun onRetrievePasswordClicked(username: String) {
        if (username.isBlank()) {
            view.showEmptyUsernameError()
            return
        }

        val password = model.retrievePassword(username)
        if (password == null) {
            view.showUserNotFoundError()
        } else {
            view.showPasswordRetrieved(password)
        }
    }

    override fun onBackToLoginClicked() {
        view.navigateToLogin()
    }
}
