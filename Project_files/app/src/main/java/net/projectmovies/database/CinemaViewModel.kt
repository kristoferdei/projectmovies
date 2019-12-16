package net.projectmovies.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CinemaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CinemaRepository
    val allCinemas: LiveData<List<Cinema>>

    init {
        val cinemasDao = CinemaRoomDatabase.getDatabase(application, viewModelScope).cinemaDao()
        repository = CinemaRepository(cinemasDao)
        allCinemas = repository.allCinemas
    }

    fun insert(cinema: Cinema) = viewModelScope.launch {
        repository.insert(cinema)

    }

}
