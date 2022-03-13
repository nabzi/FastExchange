package ir.sample.fastexchange.di

import com.google.gson.Gson
import ir.sample.fastexchange.data.repository.*
import ir.sample.fastexchange.model.ExchangeManager
import ir.sample.fastexchange.model.ExchangeManagerImpl
import ir.sample.fastexchange.ui.ExchangeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Gson() }

    //Repository
    single<BalanceRepository> { BalanceRepositoryImpl(get()) }
    single<ExchangeRateRepository> { ExchangeRateRepositoryImpl() }

    //DataSource
    single { BalanceDBDataSource(get()) }

    //ViewModel
    viewModel { ExchangeViewModel(get(), get()) }

    single<ExchangeManager> { ExchangeManagerImpl(get()) }
}