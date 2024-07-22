package com.minthanhtike.bookstores.data.models.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksResponse(
    val data: Data?
)

@Serializable
data class Data(
    @SerialName("normal_books")
    val normalBooks: List<NormalBook>?,
    @SerialName("special_books")
    val specialBooks: List<SpecialBook>?
)
@Serializable
data class NormalBook(
    @SerialName("author")
    val author: Author?,
    @SerialName("book_cover")
    val bookCover: String?,
    @SerialName("category")
    val category: Category?,
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("price")
    val price: Double?,
    @SerialName("rating")
    val rating: Double?
)

@Serializable
data class SpecialBook(
    @SerialName("books")
    val books: List<Book>?,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String?
)

@Serializable
data class Author(
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?
)

@Serializable
data class Book(
    @SerialName("author")
    val author: Author?,
    @SerialName("book_cover")
    val bookCover: String?,
    @SerialName("category")
    val category: Category?,
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("price")
    val price: Double?,
    @SerialName("rating")
    val rating: Double?
)

@Serializable
data class Category(
    @SerialName("category_name")
    val categoryName: String?,
    @SerialName("id")
    val id: String?
)
