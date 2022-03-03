package ru.zar1official.chargelevelchecker.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import ru.zar1official.chargelevelchecker.di.appModule
import ru.zar1official.chargelevelchecker.di.dataModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }
    }
}