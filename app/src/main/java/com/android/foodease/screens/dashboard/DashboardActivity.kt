package com.android.foodease.screens.dashboard

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.android.foodease.R
import com.android.foodease.app.CustomApp

class DashboardActivity : Activity(), DashboardView {

    private lateinit var presenter: DashboardPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val username = intent.getStringExtra(EXTRA_USERNAME).orEmpty()

        presenter = DashboardPresenter(
            view = this,
            model = DashboardModel(application as CustomApp)
        )

        presenter.onViewReady(username)
    }

    override fun showWelcomeMessage(username: String) {
        findViewById<TextView>(R.id.textview_welcome).text =
            getString(R.string.dashboard_welcome, username)
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}

