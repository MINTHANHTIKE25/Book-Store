package com.minthanhtike.bookstores.ui.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.minthanhtike.bookstores.databinding.CategoryItemViewholderBinding
import com.minthanhtike.bookstores.domain.CategoryContainerModel

class CategoryItemViewHolder(
    private val bind: CategoryItemViewholderBinding
) : RecyclerView.ViewHolder(bind.root) {
    fun bind (categoryContainerModel: CategoryContainerModel) {
        bind.categoryTv.text = categoryContainerModel.name
    }
}