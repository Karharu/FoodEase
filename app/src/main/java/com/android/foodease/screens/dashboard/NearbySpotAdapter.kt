package com.android.foodease.screens.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.foodease.R
import com.android.foodease.common.data.Food

class NearbySpotAdapter(
    private val spots: ArrayList<Food>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<NearbySpotAdapter.NearbySpotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbySpotViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nearby_spot, parent, false)
        return NearbySpotViewHolder(view)
    }

    override fun onBindViewHolder(holder: NearbySpotViewHolder, position: Int) {
        holder.bind(spots[position])
        holder.itemView.setOnClickListener { onItemClick(position) }
    }

    override fun getItemCount(): Int = spots.size

    fun updateFoods(newSpots: List<Food>) {
        spots.clear()
        spots.addAll(newSpots)
        notifyDataSetChanged()
    }

    class NearbySpotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageview_nearby_icon)
        private val nameView: TextView = itemView.findViewById(R.id.textview_nearby_name)
        private val categoryView: TextView = itemView.findViewById(R.id.textview_nearby_category)
        private val ratingView: TextView = itemView.findViewById(R.id.textview_nearby_rating)
        private val reviewsView: TextView = itemView.findViewById(R.id.textview_nearby_reviews)

        fun bind(food: Food) {
            imageView.setImageResource(food.imageRes)
            nameView.text = food.foodName
            categoryView.text = food.subtitle
            ratingView.text = food.rating
            reviewsView.text = food.reviews
        }
    }
}
