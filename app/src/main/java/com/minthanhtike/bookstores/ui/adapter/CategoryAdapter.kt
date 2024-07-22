package com.minthanhtike.bookstores.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minthanhtike.bookstores.databinding.CategoryItemViewholderBinding
import com.minthanhtike.bookstores.databinding.CategoryRecyclerViewholderBinding
import com.minthanhtike.bookstores.domain.CategoryContainerModel
import com.minthanhtike.bookstores.ui.viewHolder.CategoryItemViewHolder
import com.minthanhtike.bookstores.ui.viewHolder.CategoryRecyclerViewHolder


class CategoryAdapter(val onClick:(Int)-> Unit) : RecyclerView.Adapter<CategoryItemViewHolder>() {
    private var cateogryList = emptyList<CategoryContainerModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CategoryItemViewHolder  {
        CategoryItemViewholderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ).apply {
            return CategoryItemViewHolder(this)
        }
    }

    override fun getItemCount(): Int {
        return cateogryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(productLists: List<CategoryContainerModel>) {
        cateogryList = productLists
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bind(cateogryList[position])
    }
}