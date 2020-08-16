package com.paul.android.cryptocoinandroidapplication.dagger.modules

import android.app.Application
import com.paul.android.cryptocoinandroidapplication.database.dao.CryptoDao
import com.paul.android.cryptocoinandroidapplication.database.db.CryptoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun cryptoDaoProvider(application: Application): CryptoDao =
        CryptoDatabase.getDatabase(application).dao()
}