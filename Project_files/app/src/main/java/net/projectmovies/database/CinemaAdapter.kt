package net.projectmovies.database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.projectmovies.R


class CinemaAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var cinemas = emptyList<Cinema>()

    inner class CinemaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cinemaItemView: TextView = itemView.findViewById(R.id.textViewCinema)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        val itemView = inflater.inflate(R.layout.layout_cinema, parent, false)
        return CinemaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        val current = cinemas[position]
        holder.cinemaItemView.text = current.cinema
    }

    internal fun setCinemas(cinemas: List<Cinema>) {
        this.cinemas = cinemas
        notifyDataSetChanged()
    }

    override fun getItemCount() = cinemas.size

}
