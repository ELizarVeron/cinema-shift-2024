package com.joker.afisha

import android.app.Application
import com.joker.afisha.di.AppModule
import com.joker.afisha.di.NetworkModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import kotlin.properties.Delegates


class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(AppModule, NetworkModule)
        }
    }
}
