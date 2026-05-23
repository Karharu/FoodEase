package com.android.foodease.screens.dashboard

import android.app.Activity
import android.os.Bundle
import android.widget.Button
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
    private lateinit var adapter: FoodAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextFood: EditText
    private lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val username = intent.getStringExtra(EXTRA_USERNAME).orEmpty()

        presenter = DashboardPresenter(
            view = this,
            model = DashboardModel(application as CustomApp)
        )

        recyclerView = findViewById(R.id.recycler_foods)
        editTextFood = findViewById(R.id.edittext_food)
        buttonAdd = findViewById(R.id.button_add)

        adapter = FoodAdapter(
            arrayListOf(),
            onItemClick = { position ->
                val food = presenter.getFoods()[position]
                showToast(food.foodName)
            },
            onItemLongClick = { position ->
                presenter.removeFood(position)
                showToast("Item Removed")
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            presenter.addFood(editTextFood.text.toString())
            editTextFood.text.clear()
        }

        presenter.onViewReady(username)
    }

    override fun showWelcomeMessage(username: String) {
        findViewById<TextView>(R.id.textview_welcome).text =
            getString(R.string.dashboard_welcome, username)
    }

    override fun displayFoods(foodList: ArrayList<Food>) {
        adapter.updateFoods(foodList)
    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}

