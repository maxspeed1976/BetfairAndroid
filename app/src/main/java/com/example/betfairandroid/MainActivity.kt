package com.example.betfairandroid

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.betfairandroid.betfair.betfair.betting.entities.market.MarketCatalogue
import com.example.betfairandroid.betfair.betfair.betting.entities.market.MarketFilter
import com.prince.betfair.betfair.betting.Betting
import com.example.betfairandroid.betfair.betfair.betting.enums.market.MarketProjection
import com.example.betfairandroid.betfair.betfair.betting.enums.market.MarketSort
import kotlinx.coroutines.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.betfairandroid.betfair.betfair.betting.entities.TimeRange

import java.util.*
import org.joda.time.DateTime





class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            Toast.makeText(this@MainActivity, "FAB is clicked...", Toast.LENGTH_LONG).show()


        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val context = applicationContext
        val flag : Boolean = true
        val adapter = runCoroutine(flag=flag)

        recyclerView.adapter = BetFairAdapter(context, adapter)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

    }

    private fun runCoroutine(flag:Boolean) = runBlocking {
        lateinit var market: List<MarketCatalogue>
        lateinit var market2: List<MarketCatalogue>
        val dt = DateTime()
       do {
           market = searchMarket(dt)
           Thread.sleep(1000)
           market2 = searchMarket(dt.plusDays(5))
           if (market2.size > market.size) {

               Toast.makeText(this@MainActivity, "New market found!", Toast.LENGTH_LONG).show()

           }
       } while (flag)

        return@runBlocking market2
    }

    private suspend fun searchMarket(dt: DateTime): List<MarketCatalogue> = withContext(Dispatchers.IO) {
        lateinit var betting: List<MarketCatalogue>
        val curDate = DateTime.now()
        val timeRange = TimeRange(from = curDate.toDate(), to = dt.toDate())
        val marketFilter = MarketFilter(
            eventTypeIds = setOf("1"), competitionIds = setOf("12374160"),
            marketTypeCodes = setOf("OVER_UNDER_35"),marketStartTime = timeRange
        )



        println(timeRange)

        val marketProjection = setOf(
            MarketProjection.COMPETITION,
            MarketProjection.MARKET_START_TIME,
            MarketProjection.EVENT,
            MarketProjection.RUNNER_DESCRIPTION
        )

        val marketSort = MarketSort.FIRST_TO_START



    betting = Betting().listMarketCatalogue(
        marketFilter, marketProjection, marketSort, null,
        200, "LCvIcfB4gzRINsJwnElRZthInzSNgPOtKLyKFEe2h9E=", "kpa783EZR3x7Sh7x")
        return@withContext betting
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as
                ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}





