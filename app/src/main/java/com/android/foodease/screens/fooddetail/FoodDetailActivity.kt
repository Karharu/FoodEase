package com.android.foodease.screens.fooddetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.foodease.R
import com.android.foodease.common.data.Food
import com.google.android.material.button.MaterialButton

class FoodDetailActivity : AppCompatActivity(), FoodDetailContract.View {

    private lateinit var presenter: FoodDetailPresenter

    private lateinit var imageviewFood: ImageView
    private lateinit var textviewFoodName: TextView
    private lateinit var textviewSubtitle: TextView
    private lateinit var textviewPrice: TextView
    private lateinit var textviewRating: TextView
    private lateinit var textviewReviews: TextView
    private lateinit var textviewDescription: TextView
    private lateinit var textviewCalories: TextView
    private lateinit var textviewPrepTime: TextView
    private lateinit var buttonBack: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val food = intent.getSerializableExtra(EXTRA_FOOD) as? Food
            ?: run { finish(); return }

        bindViews()

        val model = FoodDetailModel()
        presenter = FoodDetailPresenter(view = this, model = model)
        presenter.loadFood(food)

        // show extra detail from model
        textviewDescription.text = model.getDescription(food.foodName)
        textviewCalories.text    = model.getCalories(food.foodName)
        textviewPrepTime.text    = model.getPrepTime(food.foodName)

        buttonBack.setOnClickListener { presenter.onBackClicked() }
    }

    private fun bindViews() {
        imageviewFood       = findViewById(R.id.imageview_food)
        textviewFoodName    = findViewById(R.id.textview_food_name)
        textviewSubtitle    = findViewById(R.id.textview_subtitle)
        textviewPrice       = findViewById(R.id.textview_price)
        textviewRating      = findViewById(R.id.textview_rating)
        textviewReviews     = findViewById(R.id.textview_reviews)
        textviewDescription = findViewById(R.id.textview_description)
        textviewCalories    = findViewById(R.id.textview_calories)
        textviewPrepTime    = findViewById(R.id.textview_prep_time)
        buttonBack          = findViewById(R.id.button_back)
    }

    override fun showFoodName(name: String)      { textviewFoodName.text = name }
    override fun showSubtitle(subtitle: String)  { textviewSubtitle.text = subtitle }
    override fun showPrice(price: String)        { textviewPrice.text = price }
    override fun showRating(rating: String)      { textviewRating.text = rating }
    override fun showReviews(reviews: String)    { textviewReviews.text = reviews }
    override fun showImage(imageRes: Int)        { imageviewFood.setImageResource(imageRes) }
    override fun navigateBack()                  { onBackPressedDispatcher.onBackPressed() }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    companion object {
        const val EXTRA_FOOD = "extra_food"
    }
}