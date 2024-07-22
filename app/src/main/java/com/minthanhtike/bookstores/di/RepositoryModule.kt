package com.minthanhtike.bookstores.di

import com.minthanhtike.bookstores.data.repos.BooksRepo
import org.koin.dsl.module

val repoModule= module {
    single {
        BooksRepo(
            bookRemoteDataSource = get(),
        )
    }
}