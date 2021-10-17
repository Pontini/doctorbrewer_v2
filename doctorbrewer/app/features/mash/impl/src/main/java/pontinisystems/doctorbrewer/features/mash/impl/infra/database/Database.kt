package pontinisystems.movie.infra.database

import android.content.Context
import androidx.room.Room
import pontinisystems.movie.infra.database.dao.MovieDao

class Database(context: Context) {

    companion object {
        const val DB_NAME = "database-tmdb-control"
    }

    private val db = Room.databaseBuilder(context, DataBaseBuilder::class.java, DB_NAME)
        .fallbackToDestructiveMigration().build()


    fun movieDao(): MovieDao {
        return db.stockFavoriteEntityDaO()
    }

}