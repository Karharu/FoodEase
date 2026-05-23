package com.android.foodease.screens.forgotpassword

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.foodease.R
import com.android.foodease.app.CustomApp
import com.android.foodease.common.utils.getEditTextValue
import com.android.foodease.common.utils.showToast
import com.android.foodease.screens.login.LoginActivity

class ForgotPasswordActivity : Activity(), ForgotPasswordView {

    private lateinit var presenter: ForgotPasswordPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        presenter = ForgotPasswordPresenter(
            view = this,
            model = ForgotPasswordModel(application as CustomApp)
        )

        findViewById<Button>(R.id.button_recover_password).setOnClickListener {
            presenter.onRetrievePasswordClicked(
                username = getEditTextValue(R.id.edittext_forgot_password_username)
            )
        }

        findViewById<TextView>(R.id.textview_back_to_login).setOnClickListener {
            presenter.onBackToLoginClicked()
        }
    }

    override fun showEmptyUsernameError() {
        showToast(getString(R.string.error_empty_fields))
    }

    override fun showUserNotFoundError() {
        showToast(getString(R.string.error_user_not_found))
    }

    override fun showPasswordRetrieved(password: String) {
        showToast(getString(R.string.success_password_retrieved, password))
    }

    override fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
