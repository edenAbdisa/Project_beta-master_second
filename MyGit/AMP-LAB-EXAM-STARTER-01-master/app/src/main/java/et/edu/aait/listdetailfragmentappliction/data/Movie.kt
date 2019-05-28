package et.edu.aait.listdetailfragmentappliction.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie")
data class Movie( @PrimaryKey(autoGenerate = true) val id:Int,
                 @ColumnInfo val movieTitle:String,
                 @ColumnInfo val category:String,
                 @ColumnInfo val description:String
                   ):Serializable
