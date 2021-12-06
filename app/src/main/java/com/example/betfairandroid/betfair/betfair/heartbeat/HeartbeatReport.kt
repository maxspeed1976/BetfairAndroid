package com.example.betfairandroid.betfair.betfair.heartbeat

import com.example.betfairandroid.betfair.betfair.heartbeat.ActionPerformed

/**
 * Response from heartbeat operation
 *
 * @property actionPerformed: (required) The action performed since your last heartbeat request.
 * @property actualTimeoutSeconds: (required) The actual timeout applied to your heartbeat request, see timeout request
 * parameter description for details.
 */
data class HeartbeatReport(
    val actionPerformed: ActionPerformed,
    val actualTimeoutSeconds: Int
)
