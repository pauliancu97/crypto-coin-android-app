package com.paul.android.cryptocoinandroidapplication.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") val uid: Int? = null,
    @ColumnInfo(name = "name") val name: String
)