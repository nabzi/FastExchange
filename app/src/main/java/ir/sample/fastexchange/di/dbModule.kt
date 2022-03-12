package ir.sample.fastexchange.di

import android.app.Application
import androidx.room.Room
import ir.sample.fastexchange.data.db.BalanceDao
import ir.sample.fastexchange.data.db.DB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    fun provideDatabase(application: Application): DB {
        return Room.databaseBuilder(application, DB::class.java, "balance").build()
    }

    fun provideBalanceDao(database: DB): BalanceDao {
        return database.balanceDao()
    }

    single { provideDatabase(androidApplication()) }

    single { provideBalanceDao(get()) }
}