package com.android.foodease.screens.dashboard

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.android.foodease.R
import com.android.foodease.app.CustomApp
import com.android.foodease.common.data.Food
import com.android.foodease.common.utils.showToast

class DashboardActivity : Activity(), DashboardView {

    private lateinit var presenter: DashboardPresenterContract
    private lateinit var adapter: FoodAdapter

    private lateinit var listView: ListView
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

        listView = findViewById(R.id.listview_foods)
        editTextFood = findViewById(R.id.edittext_food)
        buttonAdd = findViewById(R.id.button_add)

        buttonAdd.setOnClickListener {
            presenter.addFood(editTextFood.text.toString())
            editTextFood.text.clear()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val food = presenter.getFoods()[position]
            showToast(food.foodName)
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            presenter.removeFood(position)
            showToast("Item Removed")
            true
        }

        presenter.onViewReady(username)
    }

    override fun showWelcomeMessage(username: String) {
        findViewById<TextView>(R.id.textview_welcome).text =
            getString(R.string.dashboard_welcome, username)
    }

    override fun displayFoods(foodList: ArrayList<Food>) {
        if (!::adapter.isInitialized) {
            adapter = FoodAdapter(this, foodList)
            listView.adapter = adapter
        } else {
            adapter.notifyDataSetChanged()
        }
    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
}

