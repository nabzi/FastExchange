package ir.sample.fastexchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import ir.sample.fastexchange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val exchangeViewModel: ExchangeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.vmodel = exchangeViewModel

        initViews()
    }

    private fun initViews() {
        populateCurrencyTypeSpinners()
    }


    private fun populateCurrencyTypeSpinners() {

    }
}