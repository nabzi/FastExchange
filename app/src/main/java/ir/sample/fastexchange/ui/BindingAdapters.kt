package ir.sample.fastexchange.ui

import android.R
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter

@BindingAdapter("currencyTypes", "spinnerIndex")
fun loadCurrencyTypes(view: Spinner, currencyTypes: List<String>, spinnerIndex: Int) {
    var spinnerAdapter: ArrayAdapter<String?>? =
        ArrayAdapter(view.context, R.layout.simple_spinner_item, currencyTypes)
            .also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                view.adapter = adapter
            }
    view.setSelection(if (spinnerIndex == 0) 0 else 1, true)

}