package fr.henry.boxomovies.main

import android.util.Log
import fr.henry.boxomovies.data.Movie
import fr.henry.boxomovies.network.ApiCalls
import fr.henry.boxomovies.network.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainController(mView: MainView) {

    private val view =mView

    fun searchMovies(title:String){
        val mCall: Call<MoviesResponse> = ApiCalls.getMovieListByTitle(title, "full")

        mCall.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>?) {
                response?.let {
                    if (it.isSuccessful && it.code() == 200) {
                        if(it.body()?.moviesList==null)
                            view.onNoResult()
                        else
                            view.onGetResult(it.body()?.moviesList!!)
                    } else {
                        Log.e("API CALL", response.message())
                    }
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                if (!call.isCanceled) {
                    Log.e("API CALL FAILED", t.message)
                }
            }
        })
    }

}