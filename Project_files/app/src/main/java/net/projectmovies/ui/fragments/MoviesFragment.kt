package net.projectmovies.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.movies_fragment.*
import net.projectmovies.R
import net.projectmovies.databinding.MoviesFragmentBinding
import net.projectmovies.models.Movie
import net.projectmovies.network.MoviesApi
import net.projectmovies.ui.adapters.MoviesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MoviesFragmentBinding>(
            inflater,
            R.layout.movies_fragment,
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        refreshLayout.setOnRefreshListener {
            fetchMovies()
        }

        fetchMovies()
    }

    private fun fetchMovies(){
        refreshLayout.isRefreshing = true

        MoviesApi()
            .getMovies().enqueue(object : Callback<List<Movie>> {
                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                    refreshLayout.isRefreshing = false
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                    refreshLayout.isRefreshing = false
                    val movies = response.body()

                    movies?.let {
                        showMovies(it)
                    }

                }

            })
    }

    private fun showMovies(movies: List<Movie>) {
        recyclerViewMovies.layoutManager = LinearLayoutManager(activity)
        recyclerViewMovies.adapter =
            MoviesAdapter(movies)

    }

}
