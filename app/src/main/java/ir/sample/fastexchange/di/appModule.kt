package ir.sample.fastexchange.di

import com.google.gson.Gson
import ir.sample.fastexchange.data.repository.BalanceDBDataSource
import ir.sample.fastexchange.data.repository.BalanceRepository
import ir.sample.fastexchange.data.repository.BalanceRepositoryImpl
import ir.sample.fastexchange.ui.ExchangeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Gson() }

    //Repository
    single<BalanceRepository> { BalanceRepositoryImpl(get()) }

    //DataSource
    single { BalanceDBDataSource(get()) }

    //ViewModel
    viewModel { ExchangeViewModel(get()) }

}