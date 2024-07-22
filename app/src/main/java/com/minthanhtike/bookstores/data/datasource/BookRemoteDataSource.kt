package com.minthanhtike.bookstores.data.datasource

import com.minthanhtike.bookstores.data.mapper.toDomain
import com.minthanhtike.bookstores.data.models.response.BooksResponse
import com.minthanhtike.bookstores.data.models.response.CategoryResponse
import com.minthanhtike.bookstores.data.utils.handle
import com.minthanhtike.bookstores.domain.BooksListModel
import com.minthanhtike.bookstores.domain.CategoryContainer
import com.minthanhtike.bookstores.domain.CategoryContainerModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders

class BookRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getBooks(token: String): Result<BooksListModel> {
        return handle<BooksResponse> {
            httpClient.get("http://54.179.102.152/api/user/books") {
                headers {
                    append(HttpHeaders.Authorization, "Bearer $token")
                }
            }
        }.map { it.toDomain() }
    }

    suspend fun getCategory(token: String): Result<CategoryContainer> {
        return handle<CategoryResponse> {
            httpClient.get("http://54.179.102.152/api/user/categories") {
                headers {
                    append(HttpHeaders.Authorization, "Bearer $token")
                }
            }
        }.map {
            CategoryContainer(
                categoryList = it.data?.categories?.filterNotNull().orEmpty()
                    .map { category -> category.toDomain() }
            )

        }
    }
}