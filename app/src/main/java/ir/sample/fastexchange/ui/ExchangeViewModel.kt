package ir.sample.fastexchange.ui

import androidx.lifecycle.*
import ir.sample.fastexchange.data.repository.BalanceRepository
import ir.sample.fastexchange.model.Balance
import ir.sample.fastexchange.model.ExchangeManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.*

class ExchangeViewModel(
    private val balanceRepository: BalanceRepository,
    private val exchangeManager: ExchangeManager
) : ViewModel() {
    private var _balanceList: MutableStateFlow<List<Balance>> = MutableStateFlow(arrayListOf())
    val balanceList: StateFlow<List<Balance>> = _balanceList
    var sourceAmount: Double? = 0.0
    var sourceCurrencyIndex = 0
    var destCurrencyIndex = 1
    val changeInExchangeParameters = MutableLiveData(Unit)

    init {
        viewModelScope.launch {
            addInitialBalances()
            balanceRepository.getBalances()
                .collect { balances ->
                    _balanceList.value = balances
                }
        }
    }

    val currencyTypes =
        _balanceList.map {
            it.map { balance ->
                balance.type.currencyCode.toString()
            }
        }.asLiveData()

    private suspend fun addInitialBalances() {
        balanceRepository.addAll(
            arrayListOf(
                Balance(Currency.getInstance("EUR"), 1000.0),
                Balance(Currency.getInstance("USD"), 0.0),
                Balance(Currency.getInstance("BGP"), 0.0)
            )
        )
    }

    private fun getTheReceivedAmount(
        sourceCurrencyCode: String,
        destinationCurrencyCode: String,
        amount: Double
    ) = exchangeManager.getReceivedAmount(
        Currency.getInstance(sourceCurrencyCode),
        Currency.getInstance(destinationCurrencyCode), amount
    )

    var receivedAmount = changeInExchangeParameters.map {
        if (currencyTypes.value.isNullOrEmpty())
            0.0
        else
            sourceAmount?.let {
                getTheReceivedAmount(
                    currencyTypes.value!![sourceCurrencyIndex],
                    currencyTypes.value!![destCurrencyIndex],
                    it
                )
            }
    }

}



