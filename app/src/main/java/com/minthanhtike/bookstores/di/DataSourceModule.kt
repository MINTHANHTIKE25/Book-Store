package com.minthanhtike.bookstores.di

import com.minthanhtike.bookstores.data.datasource.BookRemoteDataSource
import org.koin.dsl.module

val bookRemoteDataSourceModule= module {

    single {
        BookRemoteDataSource(
            httpClient = get()
        )
    }
}

val localDataSourceModule = module {

}