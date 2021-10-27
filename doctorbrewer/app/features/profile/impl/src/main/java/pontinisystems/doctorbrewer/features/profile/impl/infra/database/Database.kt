package pontinisystems.doctorbrewer.features.profile.impl.infra.database

import android.content.Context
import androidx.room.Room
import pontinisystems.doctorbrewer.features.profile.impl.infra.database.dao.ProfileDao

class Database(context: Context) {

    companion object {
        const val DB_NAME = "profile"
    }

    private val db = Room.databaseBuilder(context, DataBaseBuilder::class.java, DB_NAME)
        .fallbackToDestructiveMigration().build()


    fun profileDao(): ProfileDao {
        return db.profileDao()
    }

}