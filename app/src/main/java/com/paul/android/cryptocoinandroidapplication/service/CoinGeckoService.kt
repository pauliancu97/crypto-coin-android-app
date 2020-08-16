package com.paul.android.cryptocoinandroidapplication.service

import com.paul.android.cryptocoinandroidapplication.service.responses.CoinMarketResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoService {
    @GET("simple/supported_vs_currencies")
    suspend fun getSupportedCurrencies(): List<String>

    @GET("coins/markets")
    suspend fun getCoinMarketData(
        @Query("vs_currency") currency: String,
        @Query("price_change_percentage") priceChangePercentage: String
    ): CoinMarketResponse

    companion object {
        const val BASE_URL = "https://api.coingecko.com/api/v3/"
    }
}