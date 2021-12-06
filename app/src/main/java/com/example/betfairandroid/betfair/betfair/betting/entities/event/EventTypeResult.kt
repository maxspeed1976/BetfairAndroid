package com.example.betfairandroid.betfair.betfair.betting.entities.event

import com.example.betfairandroid.betfair.betfair.betting.entities.event.EventType

/**
 * EventType Result
 *
 * @property eventType: The ID identifying the Event Type
 * @property marketCount: Count of markets associated with this eventType
 */
data class EventTypeResult(
    val eventType: EventType?,
    val marketCount: Int?
)