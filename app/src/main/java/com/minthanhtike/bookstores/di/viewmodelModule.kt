package com.minthanhtike.bookstores.di

import com.minthanhtike.bookstores.ui.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel {
        HomeViewModel(
             booksRepo = get(),
        )
    }
}