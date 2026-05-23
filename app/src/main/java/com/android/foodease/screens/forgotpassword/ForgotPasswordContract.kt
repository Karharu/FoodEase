package com.android.foodease.screens.forgotpassword

interface ForgotPasswordView {
    fun showEmptyUsernameError()
    fun showUserNotFoundError()
    fun showPasswordRetrieved(password: String)
    fun navigateToLogin()
}

interface ForgotPasswordPresenterContract {
    fun onRetrievePasswordClicked(username: String)
    fun onBackToLoginClicked()
}
