package ir.sample.fastexchange.data.repository

import ir.sample.fastexchange.model.Balance
import java.util.*
import kotlin.collections.ArrayList

object BalanceRepository {
    fun loadBalanceList(): ArrayList<Balance> {
        return arrayListOf(
            Balance(1000.0, Currency.getInstance("EUR")),
            Balance(0.0, Currency.getInstance("USD")),
            Balance(0.0, Currency.getInstance("BGP")),
        )
    }
}