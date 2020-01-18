package fr.henry.boxomovies.network

import fr.henry.boxomovies.data.Movie
import retrofit2.Call

object ApiCalls {

    fun getMovieById(imdbId: String, plot: String): Call<Movie> {
        return ApiClient.serviceAPI.getMovieById(imdbId, plot)
    }

    fun getMovieListByTitle(search: String, plot: String): Call<MoviesResponse> {
        return ApiClient.serviceAPI.getMovieListByTitle(search, plot)
    }
}
