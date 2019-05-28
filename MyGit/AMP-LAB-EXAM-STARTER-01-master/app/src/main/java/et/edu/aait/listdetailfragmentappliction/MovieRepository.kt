package et.edu.aait.listdetailfragmentappliction

import androidx.lifecycle.LiveData
import et.edu.aait.listdetailfragmentappliction.data.Movie

class MovieRepository(movieDAO:MovieDAO) {
    private var movieDao=movieDAO

    fun getAllMovie():LiveData<List<Movie>>{
       return movieDao.getAllMovie()
    }

    fun getMovieBytTitle(title:String): LiveData<Movie> {
        return movieDao.getMovieBytTitle(title)
    }


    fun insert(movie: Movie):Int{
        return movieDao.insert(movie)
    }


    fun delete(title:String):Long{
        return movieDao.delete(title)
    }


    fun update(movie:Movie):Long{
        return movieDao.update(movie)
    }
}