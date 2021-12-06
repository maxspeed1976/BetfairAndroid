package com.example.betfairandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.betfairandroid.betfair.betfair.betting.entities.market.MarketCatalogue


class BetFairAdapter(private val context: Context, private val list :List<MarketCatalogue>) :
    RecyclerView.Adapter<BetFairAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val openDate: TextView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            openDate = view.findViewById(R.id.open_date)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item

        return ViewHolder(inflater.inflate(R.layout.row_item, viewGroup, false))
          }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = list[position].event?.name ?: "no"
        viewHolder.openDate.text = list[position].totalMatched?.toInt().toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = list.count()

}
