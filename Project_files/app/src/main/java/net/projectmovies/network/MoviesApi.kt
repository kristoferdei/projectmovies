package net.projectmovies.network

import net.projectmovies.models.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val MY_URL = "https://my-json-server.typicode.com/kristoferdei/projectmovies/"

interface MoviesApi {

    @GET("posts")
    fun getMovies() : Call<List<Movie>>

    companion object {
        operator fun invoke() : MoviesApi {
            return Retrofit.Builder()
                .baseUrl(MY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesApi::class.java)

        }

    }

}
