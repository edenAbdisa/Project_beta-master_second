package et.edu.aait.listdetailfragmentappliction

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import et.edu.aait.listdetailfragmentappliction.data.Movie
import et.edu.aait.roomdbexample.data.MyDatabase

class MovieViewModel(application:Application): ViewModel() {
    private var movieRepo:MovieRepository
    private var movieDAO:MovieDAO

    init{
        val database=MyDatabase.getDatabase(application)
        movieDAO=database.getMovieDAO()
        movieRepo=MovieRepository(movieDAO)
    }

    fun insertMovie(movie: Movie){
         movieRepo.insert(movie)
    }
    fun getAllMovie(): LiveData<List<Movie>> {
        return movieRepo.getAllMovie()
    }

    fun getMovieBytTitle(title:String): LiveData<Movie> {
        return movieRepo.getMovieBytTitle(title)
    }

    fun delete(title:String):Long{
        return movieRepo.delete(title)
    }


    fun update(movie:Movie):Long{
        return movieRepo.update(movie)
    }

}