package net.projectmovies.database

import androidx.lifecycle.LiveData

class CinemaRepository(private val cinemaDAO : CinemaDAO) {

        val allCinemas: LiveData<List<Cinema>> = cinemaDAO.getAlphabetizedCinemas()

        suspend fun insert(cinema: Cinema) {
            cinemaDAO.insert(cinema)

    }

}

