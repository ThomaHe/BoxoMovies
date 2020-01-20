package fr.henry.boxomovies.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.henry.boxomovies.R
import fr.henry.boxomovies.data.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MainAdapter(private val movieList:MutableList<Movie>, private val context:Context,private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){


    override fun getItemCount(): Int {
       return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle?.text = movieList[position].title
        Glide.with(context).load(movieList[position].poster).into(holder.poster)

        holder.bind(movieList[position],itemClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false))
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val poster =view.movie_poster
        val movieTitle = view.movie_title

        fun bind(movie: Movie,clickListener: OnItemClickListener)
        {
              itemView.setOnClickListener {
                clickListener.onItemClicked(movie)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClicked(movie: Movie)
    }
}