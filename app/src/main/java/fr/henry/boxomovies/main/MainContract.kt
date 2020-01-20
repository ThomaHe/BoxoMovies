package fr.henry.boxomovies.main

import fr.henry.boxomovies.data.Movie

interface MainContract {

    interface MainView {
        fun onGetResult(movies: List<Movie>)
        fun onNoResult()
    }

    interface MainPresenter{
        fun searchMovies(title:String)
    }
}