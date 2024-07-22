package com.minthanhtike.bookstores.ui.viewHolder

import androidx.recyclerview.widget.LinearLayoutManager
import com.minthanhtike.bookstores.databinding.BooksViewholderBinding
import com.minthanhtike.bookstores.domain.BestSellerBookListContainer
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.ui.adapter.BookAdapter

class BestSellerRecyclerHomeViewHolder(
    private val bestSellerViewHolder: BooksViewholderBinding
):BaseHomeViewHolder(bestSellerViewHolder) {
    private val adapter = BookAdapter{}
    private val recyclerView = bestSellerViewHolder.homeMainVh
    override fun bind(data: BookContainerModel) {
        recyclerView.layoutManager = LinearLayoutManager(
            bestSellerViewHolder.root.context,
            LinearLayoutManager.HORIZONTAL,false
        )
        if (data is BestSellerBookListContainer){
            bestSellerViewHolder.recommendTxt.text=data.title
            adapter.updateList(data.bestSellerBookList)
            recyclerView.adapter = adapter
        }
    }

}