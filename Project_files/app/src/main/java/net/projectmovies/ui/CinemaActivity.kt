package net.projectmovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.projectmovies.R
import net.projectmovies.database.CinemaAdapter
import net.projectmovies.database.CinemaViewModel

class CinemaActivity : AppCompatActivity() {

    private lateinit var cinemaViewModel: CinemaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinema)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerviewCinema)
        val adapter = CinemaAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        cinemaViewModel = ViewModelProvider(this).get(CinemaViewModel::class.java)

        cinemaViewModel.allCinemas.observe(this, Observer { cinemas ->
            cinemas?.let { adapter.setCinemas(it) }
        })

    }

}
