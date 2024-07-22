package com.minthanhtike.bookstores.ui.viewHolder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.minthanhtike.bookstores.domain.BookContainerModel

abstract class BaseHomeViewHolder(binding: ViewBinding):RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(data: BookContainerModel)
}

abstract class BaseBookViewHolder(binding: ViewBinding):RecyclerView.ViewHolder(binding.root) {
}