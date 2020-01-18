package fr.henry.boxomovies.network

import fr.henry.boxomovies.data.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(".")
    fun getMovieById(@Query("i") imdbId: String, @Query("plot") plot: String): Call<Movie>

    @GET(".")
    fun getMovieListByTitle(@Query(value = "s", encoded = true) search: String, @Query("plot") plot: String): Call<MoviesResponse>
}