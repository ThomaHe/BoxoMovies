package fr.henry.boxomovies.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fr.henry.boxomovies.data.Movie

class MoviesResponse {
    @SerializedName("Search")
    @Expose
    var moviesList: List<Movie>? = null

    @SerializedName("totalResults")
    @Expose
    var totalResults: String? = null

    @SerializedName("Response")
    @Expose
    var response: String? = null
}