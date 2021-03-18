package fr.henry.boxomovies.details

import fr.henry.boxomovies.data.Movie

interface DetailsContract {

    interface DetailsView {
        fun onMovieFound(movie: Movie)
    }

    interface DetailsPresenter{
        fun searchMovie(movieId:String)
        fun onDestroyView()
    }
}