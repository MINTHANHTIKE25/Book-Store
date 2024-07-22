package com.minthanhtike.bookstores.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minthanhtike.bookstores.databinding.BestSellerViewholderBinding
import com.minthanhtike.bookstores.databinding.NewArrivalViewholderBinding
import com.minthanhtike.bookstores.databinding.PopularBookViewholderBinding
import com.minthanhtike.bookstores.databinding.RecommendViewholderBinding
import com.minthanhtike.bookstores.domain.BestSellerBookModel
import com.minthanhtike.bookstores.domain.NewArrivalsBookModel
import com.minthanhtike.bookstores.domain.NormalBooksModel
import com.minthanhtike.bookstores.domain.RecommendBookModel
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.domain.BookTypeModel
import com.minthanhtike.bookstores.ui.viewHolder.BaseBookViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.BestSellerViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.NewArrivalViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.PopularBookViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.RecommendViewHolder

class BookAdapter(val onClick: (Int) -> Unit) : RecyclerView.Adapter<BaseBookViewHolder>() {
    private var bookList = emptyList<BookTypeModel>()
    private val RECOMMENDBOOK = 0
    private val BESTSELLERBOOK = 1
    private val NEWARRIVALBOOK = 2
    private val NORMALBOOK = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBookViewHolder {
        when (viewType) {
            RECOMMENDBOOK -> {
                RecommendViewholderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ).apply {
                    return RecommendViewHolder(this)
                }
            }

            BESTSELLERBOOK -> {
                BestSellerViewholderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ).apply {
                    return BestSellerViewHolder(this)
                }
            }

            NORMALBOOK -> {
                PopularBookViewholderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ).apply {
                    return PopularBookViewHolder(this)
                }
            }

            NEWARRIVALBOOK -> {
                NewArrivalViewholderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ).apply {
                    return NewArrivalViewHolder(this)
                }
            }
            else -> {
                RecommendViewholderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ).apply {
                    return RecommendViewHolder(this)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (bookList[position]) {
            is RecommendBookModel -> RECOMMENDBOOK
            is BestSellerBookModel -> BESTSELLERBOOK
            is NewArrivalsBookModel -> NEWARRIVALBOOK
            is NormalBooksModel -> NORMALBOOK
            else -> RECOMMENDBOOK
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(productLists: List<BookTypeModel>) {
        bookList = productLists
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: BaseBookViewHolder, position: Int) {
        when (holder) {
            is RecommendViewHolder -> {
                if (bookList[position] is RecommendBookModel) {
                    holder.bind(bookList[position] as RecommendBookModel)
                }
            }

            is BestSellerViewHolder -> {
                if (bookList[position] is BestSellerBookModel) {
                    holder.bind(bookList[position] as BestSellerBookModel)
                }
            }

            is PopularBookViewHolder -> {
                if (bookList[position] is NormalBooksModel) {
                    holder.bind(bookList[position] as NormalBooksModel)
                }
            }

            is NewArrivalViewHolder -> {
                if (bookList[position] is NewArrivalsBookModel) {
                    holder.bind(bookList[position] as NewArrivalsBookModel)
                }
            }
        }
    }
}