package com.paul.android.cryptocoinandroidapplication.ui

import androidx.lifecycle.*
import com.paul.android.cryptocoinandroidapplication.repositories.CurrenciesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoadingScreenViewModelFactory @Inject constructor(
    private val currenciesRepository: CurrenciesRepository
){
    fun create() = object: ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoadingScreenViewModel(currenciesRepository) as T
        }
    }
}

class LoadingScreenViewModel(
    private val currenciesRepository: CurrenciesRepository
): ViewModel() {
    private val isLoadedObservable: MutableLiveData<Boolean> = MutableLiveData(false)

    init{
        viewModelScope.launch {
            currenciesRepository.getCurrenciesFromServiceIfNotPresent()
            isLoadedObservable.value = true
        }
    }

    fun isLoaded(): LiveData<Boolean> = isLoadedObservable
}