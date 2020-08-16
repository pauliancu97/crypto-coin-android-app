package com.paul.android.cryptocoinandroidapplication.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.paul.android.cryptocoinandroidapplication.database.entities.CoinWithBriefDataList
import com.paul.android.cryptocoinandroidapplication.database.entities.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {
    @Transaction
    @Query("SELECT * FROM coin LIMIT 100")
    fun getTopCryptoCoins(): Flow<List<CoinWithBriefDataList>>

    @Query("SELECT * FROM currency")
    fun getCurrencies(): Flow<List<CurrencyEntity>>

    @Insert
    fun insert(currencyEntity: CurrencyEntity)

    @Query("SELECT COUNT(*) FROM currency")
    suspend fun getNumberOfCurrencies(): Int
}