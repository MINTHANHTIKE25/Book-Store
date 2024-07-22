package com.minthanhtike.bookstores.ui.viewHolder

import androidx.recyclerview.widget.LinearLayoutManager
import com.minthanhtike.bookstores.databinding.BooksViewholderBinding
import com.minthanhtike.bookstores.domain.RecommendBookContainerList
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.ui.adapter.BookAdapter

class RecommendRecyclerHomeViewHolder(
    private val recommendBookViewHolder: BooksViewholderBinding
) : BaseHomeViewHolder(recommendBookViewHolder) {
    private val recyclerView = recommendBookViewHolder.homeMainVh
    override fun bind(data: BookContainerModel) {
        recyclerView.layoutManager = LinearLayoutManager(
            recommendBookViewHolder.root.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val adapter = BookAdapter {}
        if (data is RecommendBookContainerList) {
            recommendBookViewHolder.recommendTxt.text = data.title
            adapter.updateList(data.recommendedBookList)
            recyclerView.adapter=adapter
        }
    }

}