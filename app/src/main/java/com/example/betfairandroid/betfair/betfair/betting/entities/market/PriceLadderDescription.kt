package com.example.betfairandroid.betfair.betfair.betting.entities.market

import com.example.betfairandroid.betfair.betfair.betting.enums.market.PriceLadderType

/**
 * Description of the price ladder type and any related data.
 *
 * @property type: (required) The type of price ladder.
 */
data class PriceLadderDescription(
    val type: PriceLadderType
)
