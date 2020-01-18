package fr.henry.boxomovies.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.henry.boxomovies.R
import fr.henry.boxomovies.data.Movie
import fr.henry.boxomovies.details.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView, MainAdapter.OnItemClickListener {


    private lateinit var mainAdapter: MainAdapter
    private var mMovieList: MutableList<Movie> = mutableListOf()
    private lateinit var mMainController : MainController
    private var mLastSearch: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainController = MainController(this)
        mainAdapter = MainAdapter(mMovieList,this, this)
        movie_recycler.layoutManager = LinearLayoutManager(this)
        movie_recycler.adapter = mainAdapter

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchMenuItem = menu?.findItem(R.id.search)
        val searchView = searchMenuItem?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
        searchView.queryHint = getString(R.string.search_hint)

        searchMenuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                // the search view is now open. add your logic if you want
                Handler().post {
                    searchView.requestFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(searchView.findFocus(), 0)
                }
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                return true
            }
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(newSearch: String): Boolean {
                searchMovies(newSearch)
                return false
            }

            override fun onQueryTextChange(newSearch: String): Boolean {
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reload -> {
                if(!mLastSearch.isNullOrEmpty())
                    searchMovies(mLastSearch)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun searchMovies(title:String){
        mMainController.searchMovies(title)
        mLastSearch=title
    }

    override fun onGetResult(movies: List<Movie>) {
        mMovieList.clear()
        mMovieList.addAll(movies)
        mainAdapter.notifyDataSetChanged()
    }

    override fun onNoResult() {
        mMovieList.clear()
        mainAdapter.notifyDataSetChanged()
        Toast.makeText(this, getString(R.string.no_result), Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(movie: Movie) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, movie.imdbid)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "MEDIA_ID"
    }
}