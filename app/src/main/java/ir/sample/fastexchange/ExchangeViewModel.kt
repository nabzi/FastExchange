package ir.sample.fastexchange

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*
import kotlin.collections.ArrayList

data class Balance(var amount: Double, var type: Currency)

class ExchangeViewModel : ViewModel() {
    private val _balanceList = MutableStateFlow<ArrayList<Balance>>(arrayListOf())
    val balanceList: StateFlow<ArrayList<Balance>> = _balanceList
    init {
        _balanceList.value = Repository.loadBalanceList()
    }
}
object Repository{
    fun loadBalanceList() : ArrayList<Balance>{
        return arrayListOf(
            Balance(1000.0, Currency.getInstance("EUR")),
            Balance(0.0, Currency.getInstance("USD")),
            Balance(0.0, Currency.getInstance("BGP")),
        )
    }
}