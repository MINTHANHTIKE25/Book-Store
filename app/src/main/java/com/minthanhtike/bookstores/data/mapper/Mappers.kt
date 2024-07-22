package com.minthanhtike.bookstores.data.mapper

import com.minthanhtike.bookstores.data.models.response.Book
import com.minthanhtike.bookstores.data.models.response.BooksResponse
import com.minthanhtike.bookstores.data.models.response.Categories
import com.minthanhtike.bookstores.data.models.response.NormalBook
import com.minthanhtike.bookstores.data.models.response.SpecialBook
import com.minthanhtike.bookstores.domain.AuthorModel
import com.minthanhtike.bookstores.domain.BestSellerBookListContainer
import com.minthanhtike.bookstores.domain.BestSellerBookModel
import com.minthanhtike.bookstores.domain.BooksListModel
import com.minthanhtike.bookstores.domain.CategoryModel
import com.minthanhtike.bookstores.domain.NewArrivalBookListContainer
import com.minthanhtike.bookstores.domain.NewArrivalsBookModel
import com.minthanhtike.bookstores.domain.NormalBookContainerList
import com.minthanhtike.bookstores.domain.NormalBooksModel
import com.minthanhtike.bookstores.domain.RecommendBookContainerList
import com.minthanhtike.bookstores.domain.RecommendBookModel
import com.minthanhtike.bookstores.domain.BookContainerModel
import com.minthanhtike.bookstores.domain.CategoryContainerModel
import java.util.Collections

fun BooksResponse.toDomain(): BooksListModel {
    return this.data?.let { data ->
        val resultList = data.specialBooks.orEmpty().toDomain() + data.normalBooks.orEmpty()
            .toDomainModel()
        Collections.swap(resultList, resultList.lastIndex - 1, resultList.lastIndex)
        BooksListModel(
            bookContainerModel = resultList,
        )
    } ?: BooksListModel(
        bookContainerModel = emptyList()
    )
}

fun List<NormalBook>.toDomainModel(): List<BookContainerModel> {
    return listOf<BookContainerModel>(
        NormalBookContainerList(
            title = "Popular Books",
            normalBookList = this.map {
                it.toDomain()
            }
        ))
}

fun List<SpecialBook>.toDomain(): List<BookContainerModel> {
    val resultList = mutableListOf<BookContainerModel>()
    this.forEach { specialBook ->
        if (specialBook.type != null) {
            when (specialBook.type) {
                "BANNER" -> {
                    resultList.add(
                        RecommendBookContainerList(
                            title = specialBook.title!!,
                            recommendedBookList = specialBook.books.orEmpty()
                                .map { it.toRecommendBook() }
                        )
                    )
                }

                "CAROUSEL" -> {
                    resultList.add(
                        BestSellerBookListContainer(
                            title = specialBook.title!!,
                            bestSellerBookList = specialBook.books.orEmpty()
                                .map { it.toBestSellerBook() }
                        )
                    )

                }

                "GRID" -> {
                    resultList.add(
                        NewArrivalBookListContainer(
                            title = specialBook.title!!,
                            newArrivalBookList = specialBook.books.orEmpty()
                                .map { it.toNewArrivalBook() }
                        )
                    )
                }
            }
        }
    }

    return resultList
}

fun NormalBook.toDomain(): NormalBooksModel {
    return NormalBooksModel(
        id = this.id!!,
        author = this.author?.let { author ->
            AuthorModel(
                id = author.id!!,
                name = author.name.orEmpty(),
                description = author.description.orEmpty()
            )
        }!!,
        category = CategoryModel(
            id = this.category!!.id!!,
            categoryName = this.category.categoryName.orEmpty()
        ),
        description = this.description.orEmpty(),
        rating = this.rating!!,
        price = this.price!!,
        name = this.name.orEmpty(),
        bookCover = this.bookCover.orEmpty(),
    )
}

fun Book.toRecommendBook(): RecommendBookModel {
    return RecommendBookModel(
        id = this.id!!,
        author = this.author?.let { author ->
            AuthorModel(
                id = author.id!!,
                name = author.name.orEmpty(),
                description = author.description.orEmpty()
            )
        }!!,
        category = CategoryModel(
            id = this.category!!.id!!,
            categoryName = this.category.categoryName.orEmpty()
        ),
        description = this.description.orEmpty(),
        rating = this.rating!!,
        price = this.price!!,
        name = this.name.orEmpty(),
        bookCover = this.bookCover.orEmpty()
    )
}

fun Book.toBestSellerBook(): BestSellerBookModel {
    return BestSellerBookModel(
        id = this.id!!,
        author = this.author?.let { author ->
            AuthorModel(
                id = author.id!!,
                name = author.name.orEmpty(),
                description = author.description.orEmpty()
            )
        }!!,
        category = CategoryModel(
            id = this.category!!.id!!,
            categoryName = this.category.categoryName.orEmpty()
        ),
        description = this.description.orEmpty(),
        rating = this.rating!!,
        price = this.price!!,
        name = this.name.orEmpty(),
        bookCover = this.bookCover.orEmpty()
    )
}

fun Book.toNewArrivalBook(): NewArrivalsBookModel {
    return NewArrivalsBookModel(
        id = this.id!!,
        author = this.author?.let { author ->
            AuthorModel(
                id = author.id!!,
                name = author.name.orEmpty(),
                description = author.description.orEmpty()
            )
        }!!,
        category = CategoryModel(
            id = this.category!!.id!!,
            categoryName = this.category.categoryName.orEmpty()
        ),
        description = this.description.orEmpty(),
        rating = this.rating!!,
        price = this.price!!,
        name = this.name.orEmpty(),
        bookCover = this.bookCover.orEmpty()
    )
}

fun Categories.toDomain(): CategoryContainerModel {
    return CategoryContainerModel(
        id = this.id!!,
        name = this.categoryName.orEmpty()
    )
}

