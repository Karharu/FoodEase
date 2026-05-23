package com.android.foodease.screens.login

class LoginPresenter(
    private val view: LoginView,
    private val model: LoginModel
) : LoginPresenterContract {

    override fun onLoginClicked(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            view.showEmptyFieldsError()
            return
        }

        if (model.isValidCredential(username, password)) {
            view.showLoginSuccess()
            view.navigateToDashboard(username)
        } else {
            view.showInvalidCredentialsError()
        }
    }

    override fun onCreateAccountClicked() {
        view.navigateToRegister()
    }

    override fun onForgotPasswordClicked() {
        view.navigateToForgotPassword()
    }
}
