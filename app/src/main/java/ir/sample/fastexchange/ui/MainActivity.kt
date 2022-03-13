package ir.sample.fastexchange.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import ir.sample.fastexchange.R
import ir.sample.fastexchange.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val exchangeViewModel: ExchangeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.vmodel = exchangeViewModel
        binding.lifecycleOwner = this
        binding.editTextSell.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                exchangeViewModel.sourceAmount = p0.toString().toDoubleOrNull()
                exchangeViewModel.changeInExchangeParameters.postValue(Unit)
            }
        })
        binding.spinnerReceiveType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                exchangeViewModel.destCurrencyIndex = p2
                exchangeViewModel.changeInExchangeParameters.postValue(Unit)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                exchangeViewModel.destCurrencyIndex = 1
            }
        }
    }
}