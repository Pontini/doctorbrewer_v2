package pontinisystems.movie.infra.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import pontinisystems.movie.infra.database.entities.MovieEntity


@Dao
interface MovieDao {
    @Transaction
    @Query("SELECT * FROM `movie`")
    suspend fun selectAll():List<MovieEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: MovieEntity):Long


    @Delete
    suspend fun delete(movieEntity: MovieEntity)

    @Transaction
    @Query("SELECT * FROM `movie` WHERE symbol=:symbol LIMIT 1")
    suspend fun selectById(symbol: String): MovieEntity?

}