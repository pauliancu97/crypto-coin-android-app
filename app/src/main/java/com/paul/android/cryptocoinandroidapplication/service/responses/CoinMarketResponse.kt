package com.paul.android.cryptocoinandroidapplication.service.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinMarketResponse(
    @Json(name = "id") val id: String,
    @Json(name = "symbol") val symbol: String,
    @Json(name = "name") val name: String,
    @Json(name = "image") val image: String,
    @Json(name = "current_price") val price: Double,
    @Json(name = "market_cap") val marketCapital: Double,
    @Json(name = "market_cap_rank") val rank: Int,
    @Json(name = "price_change_percentage_1h_in_currency") val percentChaneOneHour: Double,
    @Json(name = "price_change_percentage_24h_in_currency") val percentChangeOneDay: Double,
    @Json(name = "price_change_percentage_7d_in_currency") val percentChangeSevenDays: Double
)