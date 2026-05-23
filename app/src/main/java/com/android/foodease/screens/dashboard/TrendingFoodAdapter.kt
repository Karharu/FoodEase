package com.android.foodease.screens.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.foodease.R
import com.android.foodease.common.data.Food

class TrendingFoodAdapter(
    private val foods: ArrayList<Food>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<TrendingFoodAdapter.TrendingFoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingFoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trending_food, parent, false)
        return TrendingFoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingFoodViewHolder, position: Int) {
        holder.bind(foods[position])
        holder.itemView.setOnClickListener { onItemClick(position) }
    }

    override fun getItemCount(): Int = foods.size

    fun updateFoods(newFoods: List<Food>) {
        foods.clear()
        foods.addAll(newFoods)
        notifyDataSetChanged()
    }

    class TrendingFoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView   = itemView.findViewById(R.id.imageview_trending_food)
        private val nameView: TextView     = itemView.findViewById(R.id.textview_trending_food_name)
        private val subtitleView: TextView = itemView.findViewById(R.id.textview_trending_food_subtitle)
        private val priceView: TextView    = itemView.findViewById(R.id.textview_trending_food_price)
        private val ratingView: TextView   = itemView.findViewById(R.id.textview_trending_food_rating)

        fun bind(food: Food) {
            imageView.setImageResource(food.imageRes)
            nameView.text     = food.foodName
            subtitleView.text = food.subtitle
            priceView.text    = food.price
            ratingView.text   = food.rating
        }
    }
}