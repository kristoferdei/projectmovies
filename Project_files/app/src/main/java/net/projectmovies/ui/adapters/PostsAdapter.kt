package net.projectmovies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_posts.view.*
import net.projectmovies.R
import net.projectmovies.models.Posts

class PostsAdapter(val posts : List<Posts>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_posts, parent, false)
        )

    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]
        holder.view.textViewUserId.text = post.userId.toString()
        holder.view.textViewId.text = post.id.toString()
        holder.view.textViewTitle1.text = post.title
        holder.view.textViewBody.text = post.body

    }

    class PostsViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}
