package com.minthanhtike.bookstores.ui.viewHolder

import android.content.Context
import com.bumptech.glide.Glide
import com.minthanhtike.bookstores.databinding.RecommendViewholderBinding
import com.minthanhtike.bookstores.domain.RecommendBookModel

class RecommendViewHolder(
    private val binding: RecommendViewholderBinding
) : BaseBookViewHolder(binding) {
    val context: Context = binding.root.context
    fun bind(bookModel: RecommendBookModel) {
        Glide.with(binding.root)
            .load(bookModel.bookCover)
            .into(binding.recommendBookImg)
    }
}