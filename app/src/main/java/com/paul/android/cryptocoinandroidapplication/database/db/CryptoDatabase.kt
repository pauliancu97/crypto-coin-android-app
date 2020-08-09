package com.paul.android.cryptocoinandroidapplication.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.paul.android.cryptocoinandroidapplication.database.dao.CoinDao
import com.paul.android.cryptocoinandroidapplication.database.entities.BriefDataEntity
import com.paul.android.cryptocoinandroidapplication.database.entities.CoinEntity
import com.paul.android.cryptocoinandroidapplication.database.entities.CurrencyEntity

@Database(
    entities = [CoinEntity::class, CurrencyEntity::class, BriefDataEntity::class],
    version = 1,
    exportSchema = false
)
public abstract class CryptoDatabase: RoomDatabase(){
    abstract fun dao(): CoinDao

    companion object {
        @Volatile
        private var INSTANCE: CryptoDatabase? = null

        fun getDatabase(context: Context): CryptoDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptoDatabase::class.java,
                    "crypto_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}