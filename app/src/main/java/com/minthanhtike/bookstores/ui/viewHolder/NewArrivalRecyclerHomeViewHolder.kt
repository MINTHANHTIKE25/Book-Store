package com.minthanhtike.bookstores.ui.viewHolder

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.minthanhtike.bookstores.databinding.BooksViewholderBinding
import com.minthanhtike.bookstores.domain.NewArrivalBookListContainer
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.ui.adapter.BookAdapter

class NewArrivalRecyclerHomeViewHolder(
    private val newArrivalViewHolder: BooksViewholderBinding
) : BaseHomeViewHolder(newArrivalViewHolder) {
    override fun bind(data: BookContainerModel) {
        val adapter = BookAdapter {}
        val recyclerView = newArrivalViewHolder.homeMainVh
        recyclerView.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )
        if (data is NewArrivalBookListContainer) {
            newArrivalViewHolder.recommendTxt.text = data.title

            adapter.updateList(data.newArrivalBookList)
            recyclerView.adapter = adapter
        }

    }
}