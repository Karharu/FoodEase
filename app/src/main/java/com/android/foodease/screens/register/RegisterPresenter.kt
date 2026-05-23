package com.android.foodease.screens.register

class RegisterPresenter(
    private val view: RegisterView,
    private val model: RegisterModel
) : RegisterPresenterContract {

    override fun onRegisterClicked(
        username: String,
        password: String,
        confirmPassword: String
    ) {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            view.showEmptyFieldsError()
            return
        }

        if (password != confirmPassword) {
            view.showPasswordMismatchError()
            return
        }

        if (model.isUsernameTaken(username)) {
            view.showUsernameAlreadyTakenError()
            return
        }

        model.saveUser(username, password)
        view.showRegistrationSuccess()
        view.navigateToLogin()
    }

    override fun onAlreadyHaveAccountClicked() {
        view.navigateToLogin()
    }
}
