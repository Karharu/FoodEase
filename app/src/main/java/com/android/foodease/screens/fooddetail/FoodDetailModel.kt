package com.android.foodease.screens.fooddetail

import com.android.foodease.common.data.Food

class FoodDetailModel {

    fun getDescription(foodName: String): String {
        return when (foodName.lowercase()) {
            "gourmet burger"  -> "A juicy beef patty stacked with fresh lettuce, tomatoes, cheddar cheese, and our signature sauce — all in a toasted brioche bun."
            "spicy ramen"     -> "Rich tonkotsu broth with thin noodles, soft-boiled egg, chashu pork, nori, and a kick of chili oil."
            "classic pasta"   -> "Al dente spaghetti tossed in a slow-cooked tomato basil sauce, finished with fresh parmesan and cracked black pepper."
            else              -> "A delicious dish crafted with fresh, quality ingredients."
        }
    }

    fun getCalories(foodName: String): String {
        return when (foodName.lowercase()) {
            "gourmet burger" -> "650 kcal"
            "spicy ramen"    -> "480 kcal"
            "classic pasta"  -> "520 kcal"
            else             -> "—"
        }
    }

    fun getPrepTime(foodName: String): String {
        return when (foodName.lowercase()) {
            "gourmet burger" -> "15 min"
            "spicy ramen"    -> "20 min"
            "classic pasta"  -> "18 min"
            else             -> "—"
        }
    }
}