package com.android.foodease.screens.login

interface LoginView {
    fun showEmptyFieldsError()
    fun showInvalidCredentialsError()
    fun showLoginSuccess()
    fun navigateToDashboard(username: String)
    fun navigateToRegister()
}

interface LoginPresenterContract {
    fun onLoginClicked(username: String, password: String)
    fun onCreateAccountClicked()
}
