package ir.sample.fastexchange.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.sample.fastexchange.data.repository.BalanceRepository
import ir.sample.fastexchange.model.Balance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class ExchangeViewModel(private val balanceRepository: BalanceRepository) : ViewModel() {
    private var _balanceList :MutableStateFlow<List<Balance>> = MutableStateFlow(arrayListOf())
    val balanceList: StateFlow<List<Balance>> = _balanceList

    init{
        viewModelScope.launch {
            addInitialBalances()
            balanceRepository.getBalances()
                .collect { balances ->
                    _balanceList.value = balances
                }
        }
    }
    fun currencyTypes() =
        _balanceList.value.map {
            it.type.currencyCode.toString()
        }
    private suspend fun addInitialBalances() {
            balanceRepository.addAll(
                arrayListOf(
                    Balance(Currency.getInstance("EUR"), 1000.0),
                    Balance(Currency.getInstance("USD"), 0.0),
                    Balance(Currency.getInstance("BGP"), 0.0)
                )
            )
    }
}



