package com.minthanhtike.bookstores.ui.viewHolder

import com.bumptech.glide.Glide
import com.minthanhtike.bookstores.databinding.BestSellerViewholderBinding
import com.minthanhtike.bookstores.domain.BestSellerBookModel

class BestSellerViewHolder(
    private val binding: BestSellerViewholderBinding
) : BaseBookViewHolder(binding) {

    fun bind(bookModel:BestSellerBookModel) {
        binding.bestSellerName.text=bookModel.name
        binding.bestSellerAuthor.text = bookModel.author.name
        Glide.with(binding.root)
            .load(bookModel.bookCover)
            .into(binding.bestSellerImg)
    }

}