package com.paul.android.cryptocoinandroidapplication.repositories

import com.paul.android.cryptocoinandroidapplication.database.dao.CryptoDao
import com.paul.android.cryptocoinandroidapplication.database.entities.CurrencyEntity
import com.paul.android.cryptocoinandroidapplication.service.CoinGeckoService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrenciesRepository @Inject constructor(
    private val coinGeckoService: CoinGeckoService,
    private val cryptoDao: CryptoDao
) {
    fun getCurrencies(): Flow<List<String>> {
        return cryptoDao.getCurrencies()
            .map { currenciesEntities -> currenciesEntities.map { it.name } }
    }

    suspend fun getCurrenciesFromServiceIfNotPresent() = withContext(Dispatchers.IO) {
        if(isCurrenciesDatabaseEmpty()){
            val serviceCurrencies = coinGeckoService.getSupportedCurrencies()
            serviceCurrencies
                .map { CurrencyEntity(name = it) }
                .forEach { cryptoDao.insert(it) }
        }
    }

    private suspend fun isCurrenciesDatabaseEmpty() = cryptoDao.getNumberOfCurrencies() == 0
}