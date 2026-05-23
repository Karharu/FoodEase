package com.android.foodease.screens.register

interface RegisterView {
    fun showEmptyFieldsError()
    fun showPasswordMismatchError()
    fun showUsernameAlreadyTakenError()
    fun showRegistrationSuccess()
    fun navigateToLogin()
}

interface RegisterPresenterContract {
    fun onRegisterClicked(username: String, password: String, confirmPassword: String)
    fun onAlreadyHaveAccountClicked()
}
