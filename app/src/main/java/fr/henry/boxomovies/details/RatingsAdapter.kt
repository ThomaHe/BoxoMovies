package fr.henry.boxomovies.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.henry.boxomovies.R
import fr.henry.boxomovies.data.Rating
import kotlinx.android.synthetic.main.rating_item.view.*

class RatingsAdapter(private val ratings:List<Rating>, private val context: Context) : RecyclerView.Adapter<RatingsAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return ratings.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.critic?.text = ratings[position].source
        holder.ratingValue?.text = ratings[position].value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rating_item, parent, false))
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val critic =view.critic
        val ratingValue = view.rating_value

    }
}