package fr.henry.boxomovies.data

import com.google.gson.annotations.SerializedName

data class Movie constructor(

    @SerializedName("imdbID")
    var imdbid: String,

    @SerializedName("Title")
    var title: String? = null,

    @SerializedName("Year")
    var year: String? = null,

    @SerializedName("Plot")
    var plot: String? = null,

    @SerializedName("Released")
    var released: String? = null,

    @SerializedName("Runtime")
    var runtime: String? = null,

    @SerializedName("Genre")
    var genre: String? = null,

    @SerializedName("Director")
    var director: String? = null,

    @SerializedName("Actors")
    var actors: String? = null,

    @SerializedName("Poster")
    var poster: String? = null,

    @SerializedName("Ratings")
    var ratings: List<Rating>? = null,

    @SerializedName("imdbRating")
    var imdbrating: String? = null,

    @SerializedName("imdbVotes")
    var imdbvotes: String? = null,

    @SerializedName("Response")
    var response: String? = null
)