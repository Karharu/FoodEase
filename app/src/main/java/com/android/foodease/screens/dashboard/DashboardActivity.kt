package com.android.foodease.screens.dashboard

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.foodease.R
import com.android.foodease.app.CustomApp
import com.android.foodease.common.data.Food
import com.android.foodease.common.utils.showToast

class DashboardActivity : Activity(), DashboardView {

    private lateinit var presenter: DashboardPresenterContract
    private lateinit var trendingAdapter: TrendingFoodAdapter
    private lateinit var nearbyAdapter: NearbySpotAdapter

    private lateinit var trendingRecycler: RecyclerView
    private lateinit var nearbyRecycler: RecyclerView
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val username = intent.getStringExtra(EXTRA_USERNAME).orEmpty()

        presenter = DashboardPresenter(
            view = this,
            model = DashboardModel(application as CustomApp)
        )

        trendingRecycler = findViewById(R.id.recycler_trending)
        nearbyRecycler = findViewById(R.id.recycler_nearby)
        searchEditText = findViewById(R.id.edittext_food)

        trendingAdapter = TrendingFoodAdapter(
            arrayListOf(),
            onItemClick = { position ->
                val food = presenter.getTrendingFoods()[position]
                showToast(food.foodName)
            }
        )

        nearbyAdapter = NearbySpotAdapter(
            arrayListOf(),
            onItemClick = { position ->
                val spot = presenter.getNearbySpots()[position]
                showToast(spot.foodName)
            }
        )

        trendingRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        trendingRecycler.adapter = trendingAdapter

        nearbyRecycler.layoutManager = LinearLayoutManager(this)
        nearbyRecycler.adapter = nearbyAdapter

        presenter.onViewReady(username)
    }

    override fun showWelcomeMessage(username: String) {
        findViewById<TextView>(R.id.textview_welcome).text =
            getString(R.string.dashboard_welcome, username)
    }

    override fun displayTrending(trendingFoods: ArrayList<Food>) {
        trendingAdapter.updateFoods(trendingFoods)
    }

    override fun displayNearby(nearbySpots: ArrayList<Food>) {
        nearbyAdapter.updateFoods(nearbySpots)
    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}

