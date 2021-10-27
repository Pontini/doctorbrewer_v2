package pontinisystems.doctorbrewer.features.profile.impl.infra.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "profile")
data class ProfileEntity(

    @SerializedName("id")
    @PrimaryKey
    val id: String,
    @SerializedName("name")
    val name: String,

    @SerializedName("last_name")
    val lastName: String
)