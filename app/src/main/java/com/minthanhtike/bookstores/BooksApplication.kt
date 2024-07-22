package com.minthanhtike.bookstores

import android.app.Application
import com.minthanhtike.bookstores.di.bookRemoteDataSourceModule
import com.minthanhtike.bookstores.di.localDataSourceModule
import com.minthanhtike.bookstores.di.networkModule
import com.minthanhtike.bookstores.di.repoModule
import com.minthanhtike.bookstores.di.viewModelModule
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BooksApplication:Application() {
    override fun onCreate() {
        super.onCreate()
//        MMKV.initialize(this)
        startKoin {
            androidLogger()
            androidContext(this@BooksApplication)
            androidFileProperties()
            modules(
                viewModelModule,
                networkModule,
                bookRemoteDataSourceModule,
                localDataSourceModule,
                repoModule
            )
        }
    }
}