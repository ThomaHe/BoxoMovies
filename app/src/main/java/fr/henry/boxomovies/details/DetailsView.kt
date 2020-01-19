package fr.henry.boxomovies.details

import fr.henry.boxomovies.data.Movie

interface DetailsView {
    fun onMovieFound(movie:Movie)
}