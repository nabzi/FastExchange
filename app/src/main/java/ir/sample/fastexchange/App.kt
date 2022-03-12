package ir.sample.fastexchange

import android.app.Application
import ir.sample.fastexchange.di.appModule
import ir.sample.fastexchange.di.dbModule
import ir.sample.fastexchange.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule, networkModule, dbModule
                )
            )
        }
    }
}