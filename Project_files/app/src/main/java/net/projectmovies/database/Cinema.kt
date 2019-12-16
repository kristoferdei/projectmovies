package net.projectmovies.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cinema_table")
class Cinema(@PrimaryKey @ColumnInfo(name = "cinema") val cinema: String)
