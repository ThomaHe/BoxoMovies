package fr.henry.boxomovies.main

import fr.henry.boxomovies.data.Movie

interface MainView {
    fun onGetResult(movies:List<Movie>)
    fun onNoResult()
}