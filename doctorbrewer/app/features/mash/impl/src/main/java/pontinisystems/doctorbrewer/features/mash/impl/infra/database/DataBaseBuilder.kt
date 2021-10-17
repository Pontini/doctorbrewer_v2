package pontinisystems.movie.infra.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pontinisystems.movie.infra.database.DataBaseBuilder.Companion.DB_VERSION
import pontinisystems.movie.infra.database.dao.MovieDao
import pontinisystems.movie.infra.database.entities.MovieEntity


@Database(
    entities = [MovieEntity::class], version = DB_VERSION
)



abstract class DataBaseBuilder :RoomDatabase(){
    companion object{
        const val DB_VERSION=1
    }



    abstract fun stockFavoriteEntityDaO(): MovieDao
}