package com.minthanhtike.bookstores.data.repos

import com.minthanhtike.bookstores.data.datasource.BookRemoteDataSource
import com.minthanhtike.bookstores.domain.BooksListModel
import com.minthanhtike.bookstores.domain.CategoryContainer
import com.minthanhtike.bookstores.domain.CategoryContainerModel

private val token =
    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiMWFkMmI5ZTg5ZWZlNGEwYjk0OTgyNzVkNjhlYmRjMGMiLCJ1c2VybmFtZSI6InR0MiIsImV4cCI6MTcxODExMzE3N30.rUj1q4UraBWzVePtms5FYNwsc54ooezLCnf928mwICU"

class BooksRepo(
    private val bookRemoteDataSource: BookRemoteDataSource,
) {
    suspend fun getBooks(): Result<BooksListModel> {
        return bookRemoteDataSource.getBooks(token)
    }

    suspend fun getCategory(): Result<CategoryContainer> {
        return bookRemoteDataSource.getCategory(token)
    }
}