package com.minthanhtike.bookstores.ui.viewHolder

import com.bumptech.glide.Glide
import com.minthanhtike.bookstores.databinding.PopularBookViewholderBinding
import com.minthanhtike.bookstores.domain.NormalBooksModel

class PopularBookViewHolder(
    private val binding: PopularBookViewholderBinding
) : BaseBookViewHolder(binding) {
    fun bind(bookModel: NormalBooksModel) {
        binding.popularBookTxt.text = bookModel.name
        binding.popularBookAuthor.text = bookModel.author.name
        Glide.with(binding.root)
            .load(bookModel.bookCover)
            .into(binding.popularBookImg)
    }
}