package ir.sample.fastexchange.model

import ir.sample.fastexchange.data.repository.ExchangeRateRepository
import java.util.*

interface ExchangeManager {
    fun getReceivedAmount(
        sourceCurrency: Currency,
        destinationCurrency: Currency,
        amount: Double
    ): Double

    fun getCommissionFee(amount: Double): Double
}

class ExchangeManagerImpl(val exchangeRateRepository: ExchangeRateRepository) : ExchangeManager {
    var exchangeCount = 0
    val MAX_FREE_EXCHANGES = 5
    val COMMISSION_RATE = 0.7
    override fun getReceivedAmount(
        sourceCurrency: Currency,
        destinationCurrency: Currency,
        amount: Double
    ): Double {
        val sourceRate = exchangeRateRepository.getExchangeRate(sourceCurrency)
        val destRate = exchangeRateRepository.getExchangeRate(destinationCurrency)
        return (amount - getCommissionFee(amount))  * destRate / sourceRate
    }

    override fun getCommissionFee(amount: Double): Double {
        return if (exchangeCount <= MAX_FREE_EXCHANGES) {
            0.0
        } else {
            amount * COMMISSION_RATE
        }
    }
}