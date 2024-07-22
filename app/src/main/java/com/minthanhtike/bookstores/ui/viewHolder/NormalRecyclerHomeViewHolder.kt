package com.minthanhtike.bookstores.ui.viewHolder

import androidx.recyclerview.widget.LinearLayoutManager
import com.minthanhtike.bookstores.databinding.BooksViewholderBinding
import com.minthanhtike.bookstores.domain.NormalBookContainerList
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.ui.adapter.BookAdapter

class NormalRecyclerHomeViewHolder(
    private val normalBookViewHolder: BooksViewholderBinding
):BaseHomeViewHolder(normalBookViewHolder){
    private val adapter = BookAdapter{}
    private val normalRecycler = normalBookViewHolder.homeMainVh
    override fun bind(data: BookContainerModel) {
        normalRecycler.layoutManager=LinearLayoutManager(
            normalBookViewHolder.root.context,LinearLayoutManager.HORIZONTAL,false
        )
        normalRecycler.adapter=adapter
        if (data is NormalBookContainerList){
            normalBookViewHolder.recommendTxt.text = "Popular Books"
            adapter.updateList(data.normalBookList)
        }

    }
}