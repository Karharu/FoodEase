package com.android.foodease.screens.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.foodease.R
import com.android.foodease.app.CustomApp
import com.android.foodease.common.utils.getEditTextValue
import com.android.foodease.common.utils.showToast
import com.android.foodease.screens.dashboard.DashboardActivity
import com.android.foodease.screens.forgotpassword.ForgotPasswordActivity
import com.android.foodease.screens.register.RegisterActivity

class LoginActivity : Activity(), LoginView {

    private lateinit var presenter: LoginPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(
            view = this,
            model = LoginModel(application as CustomApp)
        )

        findViewById<Button>(R.id.button_login).setOnClickListener {
            presenter.onLoginClicked(
                username = getEditTextValue(R.id.edittext_login_username),
                password = getEditTextValue(R.id.edittext_login_password)
            )
        }

        findViewById<TextView>(R.id.textview_forgot_password).setOnClickListener {
            presenter.onForgotPasswordClicked()
        }

        findViewById<TextView>(R.id.textview_create_account).setOnClickListener {
            presenter.onCreateAccountClicked()
        }
    }

    override fun showEmptyFieldsError() {
        showToast(getString(R.string.error_empty_fields))
    }

    override fun showInvalidCredentialsError() {
        showToast(getString(R.string.error_invalid_credentials))
    }

    override fun showLoginSuccess() {
        showToast(getString(R.string.success_login))
    }

    override fun navigateToDashboard(username: String) {
        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra(DashboardActivity.EXTRA_USERNAME, username)
        startActivity(intent)
    }

    override fun navigateToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun navigateToForgotPassword() {
        startActivity(Intent(this, ForgotPasswordActivity::class.java))
    }
}
