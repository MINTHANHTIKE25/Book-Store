package com.minthanhtike.bookstores.data.models.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    @SerialName("data")
    val data: CategoryData?
)

@Serializable
data class Categories(
    @SerialName("category_name")
    val categoryName: String?,
    @SerialName("id")
    val id: String?
)

@Serializable
data class CategoryData(
    @SerialName("categories")
    val categories: List<Categories?>?
)