package com.example.betfairandroid

import com.example.betfairandroid.betfair.betfair.betting.entities.competition.Competition
import org.joda.time.DateTime

data class Rule (val competition: Competition, val  time :List<OpenTime> ){




}
data class OpenTime(val openTime: DateTime, val marketCode: List<MarketCode> )
data class MarketCode(val name: String, val betList :List<Bet>)
data class Bet (val price: String,val size:String)
