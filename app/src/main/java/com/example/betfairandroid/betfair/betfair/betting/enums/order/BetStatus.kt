package com.example.betfairandroid.betfair.betfair.betting.enums.order

/**
 * SETTLED: A matched bet that was settled normally
 * VOIDED: A matched bet that was subsequently voided by Betfair, before, during or after settlement
 * LAPSED: Unmatched bet that was cancelled by Betfair (for example at turn in play).
 * CANCELLED: Unmatched bet that was cancelled by an explicit customer action.
 */
enum class BetStatus {
    SETTLED,
    VOIDED,
    LAPSED,
    CANCELLED
}
