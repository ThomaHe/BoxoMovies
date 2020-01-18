package fr.henry.boxomovies.data

import com.google.gson.annotations.SerializedName

data class Rating constructor(

    @SerializedName("Source")
    var source: String? = null,

    @SerializedName("Value")
    var value: String? = null
)
