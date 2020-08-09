package com.paul.android.cryptocoinandroidapplication.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class CoinWithBriefDataList(
    @Embedded
    val coinEntity: CoinEntity,
    @Relation(
        parentColumn = "uid",
        entityColumn = "coin_uid"
    )
    val briefDataList: List<BriefDataEntity>
)
