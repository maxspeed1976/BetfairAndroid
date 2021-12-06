package com.example.betfairandroid.betfair.betfair.betting.entities.event

import com.example.betfairandroid.betfair.betfair.betting.entities.event.Event

/**
 * Event Result
 *
 * @property event
 * @property marketCount: Count of markets associated with this event
 */
data class EventResult(
    val event: Event?,
    val marketCount: Int?
)