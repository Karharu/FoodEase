package com.android.foodease.screens.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.foodease.app.CustomApp
import com.android.foodease.screens.login.LoginActivity
import com.android.foodease.R
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity(), ProfileContract.View {

    private lateinit var presenter: ProfilePresenter

    private lateinit var textviewUserName: TextView
    private lateinit var textviewUserSubtitle: TextView
    private lateinit var textviewAvatarInitial: TextView
    private lateinit var textviewVisitsCount: TextView
    private lateinit var textviewReviewsCount: TextView
    private lateinit var textviewFavoritesCount: TextView

    private lateinit var rowEmail: android.view.View
    private lateinit var rowPhone: android.view.View
    private lateinit var rowLocation: android.view.View

    private lateinit var buttonLogout: MaterialButton
    private lateinit var buttonGoBack: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        bindViews()

        presenter = ProfilePresenter(
            view = this,
            model = ProfileModel(application as CustomApp)
        )

        presenter.loadProfile()
        setupButtons()
    }

    private fun bindViews() {
        textviewUserName       = findViewById(R.id.textview_user_name)
        textviewUserSubtitle   = findViewById(R.id.textview_user_subtitle)
        textviewAvatarInitial  = findViewById(R.id.textview_avatar_initial)
        textviewVisitsCount    = findViewById(R.id.textview_visits_count)
        textviewReviewsCount   = findViewById(R.id.textview_reviews_count)
        textviewFavoritesCount = findViewById(R.id.textview_favorites_count)
        rowEmail               = findViewById(R.id.row_email)
        rowPhone               = findViewById(R.id.row_phone)
        rowLocation            = findViewById(R.id.row_location)
        buttonLogout           = findViewById(R.id.button_logout)
        buttonGoBack           = findViewById(R.id.button_go_back)
    }

    override fun showUserName(name: String) {
        textviewUserName.text     = name
        textviewUserSubtitle.text = "Food Explorer"
    }

    override fun showUserInitial(initial: String) {
        textviewAvatarInitial.text = initial
    }

    override fun showStats(visits: Int, reviews: Int, favorites: Int) {
        textviewVisitsCount.text    = visits.toString()
        textviewReviewsCount.text   = reviews.toString()
        textviewFavoritesCount.text = favorites.toString()
    }

    override fun showEmail(email: String) {
        rowEmail.findViewById<ImageView>(R.id.imageview_row_icon).setImageResource(R.drawable.ic_email)
        rowEmail.findViewById<TextView>(R.id.textview_row_label).text = email
    }

    override fun showPhone(phone: String) {
        rowPhone.findViewById<ImageView>(R.id.imageview_row_icon).setImageResource(R.drawable.ic_phone)
        rowPhone.findViewById<TextView>(R.id.textview_row_label).text = phone
    }

    override fun showLocation(location: String) {
        rowLocation.findViewById<ImageView>(R.id.imageview_row_icon).setImageResource(R.drawable.ic_location)
        rowLocation.findViewById<TextView>(R.id.textview_row_label).text = location
    }

    override fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finishAffinity()
    }

    override fun navigateBack() {
        onBackPressedDispatcher.onBackPressed()
    }

    private fun setupButtons() {
        buttonLogout.setOnClickListener { presenter.onLogoutClicked() }
        buttonGoBack.setOnClickListener { presenter.onBackClicked() }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}