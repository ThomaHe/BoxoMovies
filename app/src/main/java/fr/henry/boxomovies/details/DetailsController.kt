package fr.henry.boxomovies.details

import android.util.Log
import fr.henry.boxomovies.data.Movie
import fr.henry.boxomovies.network.ApiCalls
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsController(mView: DetailsView) {

    private val view =mView

    fun searchMovie(movieId:String) {
        val mCall: Call<Movie> = ApiCalls.getMovieById(movieId, "full")
        mCall.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>?) {
                response?.let {
                    if (it.isSuccessful && it.code() == 200&&it.body()!=null) {
                       view.onMovieFound(it.body()!!)
                    } else {
                        Log.e("API CALL", response.message())
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                if (!call.isCanceled) {
                    Log.e("API CALL FAILED", t.message!!)
                }
            }
        })
    }

}