package ir.sample.fastexchange.ui

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@BindingAdapter("currencyTypes")
fun loadCurrencyTypes(view: Spinner, currencyTypes: LiveData<List<String>>) {
   currencyTypes.value?.let {
        ArrayAdapter(view.context, R.layout.simple_spinner_item, it)
            .also { adapter ->
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                view.adapter = adapter
            }
    }
    //view.setSelection(if (spinnerIndex == 0) 0 else 1, true)
}
