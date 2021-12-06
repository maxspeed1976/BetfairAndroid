package com.example.betfairandroid.betfair.betfair.betting.entities.market

/**
 * @property price: (required) The price available
 * @property size: (required) The stake available
 */
data class PriceSize(
    val price: Double,
    val size: Double
)
