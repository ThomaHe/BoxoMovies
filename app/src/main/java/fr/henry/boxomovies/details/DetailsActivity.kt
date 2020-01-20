package fr.henry.boxomovies.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import fr.henry.boxomovies.R
import fr.henry.boxomovies.data.Movie
import fr.henry.boxomovies.main.MainActivity
import kotlinx.android.synthetic.main.activity_details.*

import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager


class DetailsActivity : AppCompatActivity(), DetailsContract.DetailsView {

    private lateinit var mDetailsPresenter : DetailsContract.DetailsPresenter
    private lateinit var ratingAdapter: RatingsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.details_name)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        val intent = intent
        val mMovieId = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        mDetailsPresenter = DetailsPresenter(this)
        mDetailsPresenter.searchMovie(mMovieId!!)
    }

    override fun onMovieFound(movie: Movie) {
        details_movie_title.text=movie.title
        Glide.with(this).load(movie.poster).into(details_movie_poster)
        details_released_date.text=movie.released
        details_synopsis_data.text=movie.plot
        details_runtime_data.text=movie.runtime
        details_casting_data.text=movie.actors
        details_director_data.text=movie.director
        details_genre_data.text=movie.genre

        ratingAdapter = RatingsAdapter(movie.ratings!!,this)
        ratings_recycler.layoutManager = LinearLayoutManager(this)
        ratings_recycler.adapter = ratingAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
