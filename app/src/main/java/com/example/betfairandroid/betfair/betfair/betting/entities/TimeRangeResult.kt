package com.example.betfairandroid.betfair.betfair.betting.entities

import com.example.betfairandroid.betfair.betfair.betting.entities.TimeRange

/**
 * TimeRange Result
 *
 * @property timeRange
 * @property marketCount: Count of markets associated with this TimeRange
 */
data class TimeRangeResult(
    val timeRange: TimeRange?,
    val marketCount: Int?
)
