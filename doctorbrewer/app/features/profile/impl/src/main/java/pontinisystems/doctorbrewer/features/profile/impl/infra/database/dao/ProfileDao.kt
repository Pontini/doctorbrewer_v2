package pontinisystems.doctorbrewer.features.profile.impl.infra.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import pontinisystems.doctorbrewer.features.profile.impl.infra.database.entities.ProfileEntity

@Dao
interface ProfileDao {
    /*@Transaction
    @Query("SELECT * FROM `profile`  LIMIT 1")
    suspend fun select():ProfileEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: ProfileEntity):Long


    @Delete
    suspend fun delete(data: ProfileEntity)*/

}