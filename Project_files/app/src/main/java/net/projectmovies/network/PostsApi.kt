package net.projectmovies.network

import net.projectmovies.models.Posts
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val POSTS_URL = "https://jsonplaceholder.typicode.com/"

interface PostsApi {

    @GET("posts")
    fun getPosts() : Call<List<Posts>>

    companion object {
        operator fun invoke() : PostsApi {
            return Retrofit.Builder()
                .baseUrl(POSTS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostsApi::class.java)

        }

    }

}
