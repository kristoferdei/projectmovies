package net.projectmovies.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Cinema::class), version = 1, exportSchema = false)
abstract class CinemaRoomDatabase : RoomDatabase() {

    abstract fun cinemaDao(): CinemaDAO

    private class CinemaDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var cinemaDAO = database.cinemaDao()

                    cinemaDAO.deleteAll()

                    var cinema = Cinema("Debrecen")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Nyíregyháza")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Aréna - Budapest")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Allee - Budapest")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Campona - Budapest")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Westend - Budapest")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Győr")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Pécs")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Szeged")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Miskolc")
                    cinemaDAO.insert(cinema)
                    cinema = Cinema("Sopron")
                    cinemaDAO.insert(cinema)
                    
                }

            }

        }

    }

    companion object {
        @Volatile
        private var INSTANCE: CinemaRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): CinemaRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CinemaRoomDatabase::class.java,
                    "cinema_database"
                )
                    .addCallback(CinemaDatabaseCallback(scope))
                    .build()
                INSTANCE = instance

                instance
            }

        }

    }

}
