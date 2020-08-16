package com.paul.android.cryptocoinandroidapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.paul.android.cryptocoinandroidapplication.repositories.CurrenciesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrencyFragmentViewModelFactory @Inject constructor(
    private val currenciesRepository: CurrenciesRepository
){
    fun create() = object: ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CurrenciesFragmentViewModel(currenciesRepository) as T
        }
    }
}

class CurrenciesFragmentViewModel(
    private val currenciesRepository: CurrenciesRepository
): ViewModel() {

    init{
        viewModelScope.launch {
            currenciesRepository.getCurrenciesFromServiceIfNotPresent()
        }
    }

    fun getCurrencies() = currenciesRepository.getCurrencies().asLiveData()
}