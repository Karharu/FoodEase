package com.android.foodease.common.data
data class Food(
    val foodName: String,
    val subtitle: String,
    val price: String,
    val rating: String,
    val reviews: String,
    val distance: String,
    val imageRes: Int = 0
) : java.io.Serializable