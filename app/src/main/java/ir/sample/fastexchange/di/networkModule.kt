package ir.sample.fastexchange.di

import ir.sample.fastexchange.data.remote.BASE_URL
import ir.sample.fastexchange.data.remote.createHttpClient
import ir.sample.fastexchange.data.remote.createRetrofit
import ir.sample.fastexchange.data.remote.createService
import org.koin.dsl.module

val networkModule = module {
    single { createService(get()) }
    single { createHttpClient() }
    single { createRetrofit(get(), BASE_URL) }
}

