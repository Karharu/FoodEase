package com.android.foodease.screens.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.android.foodease.R
import com.android.foodease.common.data.Food

class FoodAdapter(
    context: Context,
    private val foods: ArrayList<Food>
) : ArrayAdapter<Food>(context, 0, foods) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_food, parent, false)

        val food = foods[position]
        val foodName = view.findViewById<TextView>(R.id.textview_food_name)
        foodName.text = food.foodName

        return view
    }
}
