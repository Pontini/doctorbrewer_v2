package pontinisystems.movie.infra.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class MovieEntity(
    @SerializedName("symbol")
    @PrimaryKey
    val symbol: String,
    @SerializedName("name")
    val name: String
)