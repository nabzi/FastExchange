package ir.sample.fastexchange.data.repository

import ir.sample.fastexchange.model.Balance
import ir.sample.fastexchange.model.ExchangeRate
import ir.sample.fastexchange.model.ExchangeRates
import kotlinx.coroutines.flow.Flow
import java.util.*

interface ExchangeRateRepository {
    fun getExchangeRates() : Flow<List<ExchangeRate>>
    fun getExchangeRate(currency : Currency) : Double
}

class ExchangeRateRepositoryImpl: ExchangeRateRepository{
    override fun getExchangeRates(): Flow<List<ExchangeRate>> {
        TODO("Not yet implemented")
    }

    override fun getExchangeRate(currency: Currency): Double {
        return if(currency.currencyCode == "EUR" ) 1.0 else 2.0
    }
}