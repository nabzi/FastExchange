package ir.sample.fastexchange

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

data class Balance(var amount: Double, var type: Currency)

class ExchangeViewModel : ViewModel() {
    var balanceList = MutableLiveData<ArrayList<Balance>>()

    init {
        balanceList.postValue(
            arrayListOf<Balance>(
                Balance(1000.0, Currency.getInstance("EUR")),
                Balance(0.0, Currency.getInstance("USD")),
                Balance(0.0, Currency.getInstance("BGP")),
            )
        )
    }


}