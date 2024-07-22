package com.minthanhtike.bookstores.ui.onBoarding

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minthanhtike.bookstores.databinding.OnboardingItemContainerBinding


class OnBoardingAdapter(val onBoardingList: List<OnboardingItem>) :
    RecyclerView.Adapter<OnBoardingViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardingViewHolder {
        OnboardingItemContainerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ).apply {
            return OnBoardingViewHolder(this)
        }
    }

    override fun getItemCount(): Int {
        return onBoardingList.size
    }


    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(onBoardingList[position])
    }
}