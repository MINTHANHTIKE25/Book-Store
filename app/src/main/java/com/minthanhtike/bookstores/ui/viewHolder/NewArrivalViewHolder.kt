package com.minthanhtike.bookstores.ui.viewHolder

import com.bumptech.glide.Glide
import com.minthanhtike.bookstores.databinding.NewArrivalViewholderBinding
import com.minthanhtike.bookstores.domain.NewArrivalsBookModel

class NewArrivalViewHolder(
    private val binding: NewArrivalViewholderBinding
) : BaseBookViewHolder(binding) {

    fun bind(bookModel: NewArrivalsBookModel) {
        binding.newArrivalBookTxt.text = bookModel.name
        binding.newArrivalAuthor.text = bookModel.author.name
        Glide.with(binding.root)
            .load(bookModel.bookCover)
            .into(binding.newArrivalImg)
    }

}