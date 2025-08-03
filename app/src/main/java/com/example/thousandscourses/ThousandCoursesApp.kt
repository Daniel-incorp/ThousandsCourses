package com.example.thousandscourses

import android.app.Application
import com.example.thousandscourses.di.dbModule
import com.example.thousandscourses.di.networkModule
import com.example.thousandscourses.di.repositoryModule
import com.example.thousandscourses.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    networkModule,
                    dbModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}

