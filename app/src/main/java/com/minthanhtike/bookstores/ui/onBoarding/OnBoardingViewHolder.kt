package com.minthanhtike.bookstores.ui.onBoarding

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.minthanhtike.bookstores.R
import com.minthanhtike.bookstores.databinding.OnboardingItemContainerBinding

class OnBoardingViewHolder(
    private val viewBinding: OnboardingItemContainerBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(onboardingItem: OnboardingItem) {
        val context=viewBinding.root.context
        viewBinding.onBoardingTxt.text = onboardingItem.text
        when(onboardingItem.activeIndicator){
            0->{
                val param=viewBinding.indicatorOne.layoutParams
                param.width = context.dpToPx(26)
                viewBinding.indicatorOne.layoutParams = param
                viewBinding.indicatorOne.setBackgroundResource(R.drawable.active_indicator)
                viewBinding.indicatorTwo.setBackgroundResource(R.drawable.inactive_indicator)
                viewBinding.indicatorThree.setBackgroundResource(R.drawable.inactive_indicator)
            }
            1->{
                val param=viewBinding.indicatorTwo.layoutParams
                param.width = context.dpToPx(26)
                viewBinding.indicatorTwo.layoutParams = param
                viewBinding.indicatorOne.setBackgroundResource(R.drawable.inactive_indicator)
                viewBinding.indicatorTwo.setBackgroundResource(R.drawable.active_indicator)
                viewBinding.indicatorThree.setBackgroundResource(R.drawable.inactive_indicator)
            }
            2->{
                val param=viewBinding.indicatorThree.layoutParams
                param.width = context.dpToPx(26)
                viewBinding.indicatorThree.layoutParams = param
                viewBinding.indicatorOne.setBackgroundResource(R.drawable.inactive_indicator)
                viewBinding.indicatorTwo.setBackgroundResource(R.drawable.inactive_indicator)
                viewBinding.indicatorThree.setBackgroundResource(R.drawable.active_indicator)
            }
        }
    }
}

fun Context.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}