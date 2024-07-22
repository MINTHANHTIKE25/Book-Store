package com.minthanhtike.bookstores.ui.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minthanhtike.bookstores.R
import com.minthanhtike.bookstores.databinding.ActivityOnBoardingBinding
import com.minthanhtike.bookstores.ui.MainScreenActivity

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnBoarding()
        binding.button.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setOnBoarding() {
        val onBoardinglist= listOf(
            OnboardingItem(
                text = getString(R.string.all_your_favourites_book_in_one_place),
                activeIndicator = 0,
            ),
            OnboardingItem(
                text = getString(R.string.we_provide_you_with_all_your_favourite_books),
                activeIndicator = 1,
            ),
            OnboardingItem(
                text = getString(R.string.reading_is_filling_the_emptiness_of_your_heart),
                activeIndicator = 2
            )
        )

        binding.viewPager.adapter = OnBoardingAdapter(onBoardinglist)

    }
}