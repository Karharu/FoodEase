package com.android.foodease.screens.fooddetail

import com.android.foodease.common.data.Food

interface FoodDetailContract {

    interface View {
        fun showFoodName(name: String)
        fun showSubtitle(subtitle: String)
        fun showPrice(price: String)
        fun showRating(rating: String)
        fun showReviews(reviews: String)
        fun showImage(imageRes: Int)
        fun navigateBack()
    }

    interface Presenter {
        fun loadFood(food: Food)
        fun onBackClicked()
        fun onDestroy()
    }
}