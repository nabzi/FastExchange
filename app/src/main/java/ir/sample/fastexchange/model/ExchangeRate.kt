package ir.sample.fastexchange.model

import java.util.*

//"timestamp":1647091083,"base":"EUR","date":"2022-03-12","rates":
data class ExchangeRates(
    var timestamp: Long,
    var base: Currency,
    var date: Date,
    var rates: List<ExchangeRate>
)

data class ExchangeRate(var currency : Currency , var amount : Double)