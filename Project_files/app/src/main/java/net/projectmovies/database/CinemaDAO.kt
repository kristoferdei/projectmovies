package net.projectmovies.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CinemaDAO {

    @Query("SELECT * from cinema_table ORDER BY cinema ASC")
    fun getAlphabetizedCinemas(): LiveData<List<Cinema>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cinema: Cinema)

    @Query("DELETE FROM cinema_table")
    suspend fun deleteAll()

}
