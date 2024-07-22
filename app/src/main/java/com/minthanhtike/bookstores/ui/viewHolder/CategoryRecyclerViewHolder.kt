package com.minthanhtike.bookstores.ui.viewHolder

import androidx.recyclerview.widget.LinearLayoutManager
import com.minthanhtike.bookstores.databinding.CategoryRecyclerViewholderBinding
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.domain.CategoryContainer
import com.minthanhtike.bookstores.domain.CategoryContainerModel
import com.minthanhtike.bookstores.ui.adapter.CategoryAdapter

class CategoryRecyclerViewHolder(
    private val categoryViewHolder: CategoryRecyclerViewholderBinding
) : BaseHomeViewHolder(categoryViewHolder) {
    val recyclerView = categoryViewHolder.categoryRv
    override fun bind(data: BookContainerModel) {
        recyclerView.layoutManager = LinearLayoutManager(
            categoryViewHolder.root.context, LinearLayoutManager.HORIZONTAL, false
        )

        val adapter = CategoryAdapter {}
        if (data is CategoryContainer) {
            adapter.updateList(data.categoryList)
            recyclerView.adapter = adapter
        }
    }
}