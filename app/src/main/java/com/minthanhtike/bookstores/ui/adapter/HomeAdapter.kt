package com.minthanhtike.bookstores.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minthanhtike.bookstores.databinding.BooksViewholderBinding
import com.minthanhtike.bookstores.databinding.CategoryRecyclerViewholderBinding
import com.minthanhtike.bookstores.domain.BestSellerBookListContainer
import com.minthanhtike.bookstores.domain.NewArrivalBookListContainer
import com.minthanhtike.bookstores.domain.NormalBookContainerList
import com.minthanhtike.bookstores.domain.RecommendBookContainerList
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.domain.CategoryContainer
import com.minthanhtike.bookstores.domain.CategoryContainerModel
import com.minthanhtike.bookstores.ui.viewHolder.BaseHomeViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.BestSellerRecyclerHomeViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.CategoryRecyclerViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.NewArrivalRecyclerHomeViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.NormalRecyclerHomeViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.RecommendRecyclerHomeViewHolder

class HomeAdapter() : RecyclerView.Adapter<BaseHomeViewHolder>() {
    var booksList = listOf<BookContainerModel>()
    private val CategoryViewType = 0
    private val RecommendViewType = 1
    private val BestSellerViewType = 2
    private val NewArrivalViewType = 3
    private val NormalBookViewType = 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        when (viewType) {
            CategoryViewType -> CategoryRecyclerViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ).apply {
                return CategoryRecyclerViewHolder(this)
            }

            RecommendViewType -> BooksViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ).apply {
                return RecommendRecyclerHomeViewHolder(this)
            }

            BestSellerViewType -> BooksViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ).apply {
                return BestSellerRecyclerHomeViewHolder(this)
            }

            NewArrivalViewType -> BooksViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ).apply {
                return NewArrivalRecyclerHomeViewHolder(this)
            }

            NormalBookViewType -> BooksViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ).apply {
                return NormalRecyclerHomeViewHolder(this)
            }

            else -> BooksViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ).apply {
                return BestSellerRecyclerHomeViewHolder(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(booksList: List<BookContainerModel>) {
        this.booksList = booksList
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (booksList[position]) {
            is CategoryContainer -> CategoryViewType
            is RecommendBookContainerList -> RecommendViewType
            is BestSellerBookListContainer -> BestSellerViewType
            is NewArrivalBookListContainer -> NewArrivalViewType
            is NormalBookContainerList -> NormalBookViewType
            else -> RecommendViewType
        }
    }

    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        holder.bind(booksList[position])
    }


}