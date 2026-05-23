package com.android.foodease.screens.fooddetail

import com.android.foodease.common.data.Food

class FoodDetailPresenter(
    private var view: FoodDetailContract.View?,
    private val model: FoodDetailModel
) : FoodDetailContract.Presenter {

    override fun loadFood(food: Food) {
        view?.showFoodName(food.foodName)
        view?.showSubtitle(food.subtitle)
        view?.showPrice(food.price)
        view?.showRating(food.rating)
        view?.showReviews(food.reviews)
        view?.showImage(food.imageRes)
    }

    override fun onBackClicked() {
        view?.navigateBack()
    }

    override fun onDestroy() {
        view = null
    }
}