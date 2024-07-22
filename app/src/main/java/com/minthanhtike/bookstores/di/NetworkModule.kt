package com.minthanhtike.bookstores.di

import com.minthanhtike.bookstores.data.services.KtorUtils
import org.koin.core.scope.get
import org.koin.dsl.module

val networkModule = module {
    single {
        KtorUtils().createKtor(
            context = get()
        )
    }
}