package com.android.foodease.screens.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.foodease.R
import com.android.foodease.common.data.Food

class FoodAdapter(
    private val foods: ArrayList<Food>,
    private val onItemClick: (Int) -> Unit,
    private val onItemLongClick: (Int) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foods[position])
        holder.itemView.setOnClickListener { onItemClick(position) }
        holder.itemView.setOnLongClickListener {
            onItemLongClick(position)
            true
        }
    }

    override fun getItemCount(): Int = foods.size

    fun updateFoods(newFoods: List<Food>) {
        foods.clear()
        foods.addAll(newFoods)
        notifyDataSetChanged()
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageview_food_icon)
        private val nameView: TextView = itemView.findViewById(R.id.textview_food_name)
        private val categoryView: TextView = itemView.findViewById(R.id.textview_food_category)

        fun bind(food: Food) {
            imageView.setImageResource(food.imageRes)
            nameView.text = food.foodName
            categoryView.text = food.category
        }
    }
}
