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
import kotlinx.android.synthetic.main.movies_fragment.refreshLayout
import kotlinx.android.synthetic.main.posts_fragment.*
import net.projectmovies.R
import net.projectmovies.databinding.PostsFragmentBinding
import net.projectmovies.models.Posts
import net.projectmovies.network.PostsApi
import net.projectmovies.ui.adapters.PostsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsFragment : Fragment() {

    companion object {
        fun newInstance() = PostsFragment()
    }

    private lateinit var viewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<PostsFragmentBinding>(inflater,
            R.layout.posts_fragment,container,false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)
        refreshLayout.setOnRefreshListener {
            fetchPosts()
        }

        fetchPosts()
    }

    private fun fetchPosts(){
        refreshLayout.isRefreshing = true

        PostsApi()
            .getPosts().enqueue(object : Callback<List<Posts>> {
                override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                    refreshLayout.isRefreshing = false
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                    refreshLayout.isRefreshing = false
                    val posts = response.body()

                    posts?.let {
                        showPosts(it)
                    }

                }

            })
    }

    private fun showPosts(posts: List<Posts>) {
        recyclerViewPosts.layoutManager = LinearLayoutManager(activity)
        recyclerViewPosts.adapter =
            PostsAdapter(posts)

    }

}
