package com.paul.android.cryptocoinandroidapplication.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin")
data class Coin(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") val uid: Int,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "rank") val rank: Int
)