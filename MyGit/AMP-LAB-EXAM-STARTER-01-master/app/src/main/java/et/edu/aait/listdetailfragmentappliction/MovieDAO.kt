package et.edu.aait.listdetailfragmentappliction

import androidx.lifecycle.LiveData
import androidx.room.*
import et.edu.aait.listdetailfragmentappliction.data.Movie

@Dao
interface MovieDAO {
    @Query("SELECT * FROM movie")
    fun getAllMovie():LiveData<List<Movie>>

    @Query("SELECT * FROM MOVIE WHERE movieTitle = :title ")
    fun getMovieBytTitle(title:String):LiveData<Movie>

    @Insert
    fun insert(movie: Movie):Int

    @Delete
    fun delete(movie:String):Long

    @Update
    fun update(movie:Movie):Long


}