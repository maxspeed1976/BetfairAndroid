package com.example.betfairandroid.betfair.betfair.betting.entities.order

import com.example.betfairandroid.betfair.betfair.betting.entities.order.CancelInstructionReport
import com.example.betfairandroid.betfair.betfair.betting.entities.order.PlaceInstructionReport
import com.example.betfairandroid.betfair.betfair.betting.enums.order.InstructionReportErrorCode
import com.example.betfairandroid.betfair.betfair.betting.enums.order.InstructionReportStatus

/**
 * @property status: (required) whether the command succeeded or failed
 * @property errorCode: cause of failure, or null if command succeeds
 * @property cancelInstructionReport: Cancelation report for the original order
 * @property placeInstructionReport: Placement report for the new order
 */
data class ReplaceInstructionReport(
    val status: InstructionReportStatus,
    val errorCode: InstructionReportErrorCode?,
    val cancelInstructionReport: CancelInstructionReport?,
    val placeInstructionReport: PlaceInstructionReport?
)
