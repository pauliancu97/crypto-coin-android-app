package com.paul.android.cryptocoinandroidapplication.dagger.modules

import com.paul.android.cryptocoinandroidapplication.service.CoinGeckoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ServicesModule {

    @Provides
    @Singleton
    fun coinGeckoServiceProvider(): CoinGeckoService = Retrofit.Builder()
        .baseUrl(CoinGeckoService.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(CoinGeckoService::class.java)
}