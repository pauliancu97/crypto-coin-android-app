package com.paul.android.cryptocoinandroidapplication.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "brief_data", primaryKeys = ["coin_uid", "currency_uid"])
data class BriefDataEntity(
    @ColumnInfo(name = "coin_uid") val coinUid: Int,
    @ColumnInfo(name = "currency_uid") val currencyUid: Int,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "percent_change_one_hour") val percentChangeOneHour: Double,
    @ColumnInfo(name = "percent_change_one_day") val percentChangeOneDay: Double,
    @ColumnInfo(name = "percent_change_seven_days") val percentChangeSevenDays: Double
)