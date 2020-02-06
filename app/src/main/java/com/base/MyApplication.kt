package com.base

import android.app.Application
import com.base.di.Modules
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        insertKoin()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun insertKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    Modules.mainActivityViewModelModule,
                    Modules.pilotListModule,
                    Modules.pilotDetailsModule,
                    Modules.splashViewModelModule
                )
            )
        }
    }

}
