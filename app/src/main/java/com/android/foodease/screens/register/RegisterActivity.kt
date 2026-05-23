package com.android.foodease.screens.register

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.foodease.R
import com.android.foodease.app.CustomApp
import com.android.foodease.common.utils.getEditTextValue
import com.android.foodease.common.utils.showToast

class RegisterActivity : Activity(), RegisterView {

    private lateinit var presenter: RegisterPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(
            view = this,
            model = RegisterModel(application as CustomApp)
        )

        findViewById<Button>(R.id.button_register).setOnClickListener {
            presenter.onRegisterClicked(
                username = getEditTextValue(R.id.edittext_register_username),
                password = getEditTextValue(R.id.edittext_register_password),
                confirmPassword = getEditTextValue(R.id.edittext_register_confirm_password)
            )
        }

        findViewById<TextView>(R.id.textview_already_have_account).setOnClickListener {
            presenter.onAlreadyHaveAccountClicked()
        }
    }

    override fun showEmptyFieldsError() {
        showToast(getString(R.string.error_empty_fields))
    }

    override fun showPasswordMismatchError() {
        showToast(getString(R.string.error_password_mismatch))
    }

    override fun showUsernameAlreadyTakenError() {
        showToast(getString(R.string.error_username_taken))
    }

    override fun showRegistrationSuccess() {
        showToast(getString(R.string.success_register))
    }

    override fun navigateToLogin() {
        finish()
    }
}
