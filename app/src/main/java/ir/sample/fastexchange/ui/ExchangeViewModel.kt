package ir.sample.fastexchange.ui

import androidx.lifecycle.ViewModel
import ir.sample.fastexchange.data.repository.BalanceRepository
import ir.sample.fastexchange.model.Balance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExchangeViewModel(balanceRepository: BalanceRepository) : ViewModel() {
    private val _balanceList = MutableStateFlow<ArrayList<Balance>>(arrayListOf())
    val balanceList: StateFlow<ArrayList<Balance>> = _balanceList

    init {
        _balanceList.value = balanceRepository.loadBalanceList()
    }

    fun currencyTypes() =
        _balanceList.value.map {
            it.type.currencyCode.toString()
        }
}



