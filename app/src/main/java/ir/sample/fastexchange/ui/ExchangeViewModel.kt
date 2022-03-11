package ir.sample.fastexchange

import android.R
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import java.util.*
import kotlin.collections.ArrayList

data class Balance(var amount: Double, var type: Currency)

class ExchangeViewModel : ViewModel() {
    private val _balanceList = MutableStateFlow<ArrayList<Balance>>(arrayListOf())
    val balanceList: StateFlow<ArrayList<Balance>> = _balanceList

    init {
        _balanceList.value = Repository.loadBalanceList()
    }

    fun currencyTypes() =
        _balanceList.value.map {
            it.type.currencyCode.toString()
        }
}

object Repository {
    fun loadBalanceList(): ArrayList<Balance> {
        return arrayListOf(
            Balance(1000.0, Currency.getInstance("EUR")),
            Balance(0.0, Currency.getInstance("USD")),
            Balance(0.0, Currency.getInstance("BGP")),
        )
    }
}



//ArrayAdapter.createFromResource(
//this,
//R.array.planets_array,
//android.R.layout.simple_spinner_item
//).also { adapter ->
//    // Specify the layout to use when the list of choices appears
//    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//    // Apply the adapter to the spinner
//    spinner.adapter = adapter
//}