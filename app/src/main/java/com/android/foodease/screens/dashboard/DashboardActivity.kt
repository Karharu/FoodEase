package com.android.foodease.screens.dashboard

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.content.Intent
import android.widget.ImageView
import com.android.foodease.screens.profile.ProfileActivity
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
    private lateinit var sectionAction: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val username = intent.getStringExtra(EXTRA_USERNAME).orEmpty()

        presenter = DashboardPresenter(
            view = this,
            model = DashboardModel(application as CustomApp)
        )

        findViewById<ImageView>(R.id.imageview_avatar).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        trendingRecycler = findViewById(R.id.recycler_trending)
        nearbyRecycler = findViewById(R.id.recycler_nearby)
        searchEditText = findViewById(R.id.edittext_food)
        sectionAction = findViewById(R.id.textview_section_action)

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

        // See All click handler
        sectionAction.setOnClickListener {
            showToast(getString(R.string.dashboard_section_title))
        }

        // Search filtering
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s?.toString().orEmpty().trim().lowercase()
                filterLists(query)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

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

    private fun filterLists(query: String) {
        if (query.isEmpty()) {
            trendingAdapter.updateFoods(presenter.getTrendingFoods())
            nearbyAdapter.updateFoods(presenter.getNearbySpots())
            return
        }

        val filteredTrending = presenter.getTrendingFoods().filter {
            it.foodName.lowercase().contains(query) || it.subtitle.lowercase().contains(query)
        }

        val filteredNearby = presenter.getNearbySpots().filter {
            it.foodName.lowercase().contains(query) || it.subtitle.lowercase().contains(query)
        }

        trendingAdapter.updateFoods(ArrayList(filteredTrending))
        nearbyAdapter.updateFoods(ArrayList(filteredNearby))
    }


    override fun showMessage(message: String) {
        showToast(message)
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}

