package et.edu.aait.listdetailfragmentappliction

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import et.edu.aait.listdetailfragmentappliction.ManageContentFragment.OnManageButtonsClicked
import et.edu.aait.listdetailfragmentappliction.data.Movie

class MainActivity : AppCompatActivity(), OnManageButtonsClicked{


    private lateinit var movieViewModel:MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_layout)

        val manageContentFragment = ManageContentFragment()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.portrait_frame, manageContentFragment)
                .addToBackStack(null)
                .commit()
        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.land_manage_frame, manageContentFragment)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onAddButtonClicked(movie: Movie) {
        // insert the movie passed to database using viewModel
        movieViewModel.insertMovie(movie)
        // create DisplayContentFragment fragment using its factory method
        val displayContentFragment=DisplayContentFragment()
       val bundle= Bundle()
        bundle.putSerializable("movie",movie)
        bundle.putString("title",movie.movieTitle)
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.portrait_frame, displayContentFragment)
                .addToBackStack(null)
                .commit()
        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.land_manage_frame, displayContentFragment)
                .addToBackStack(null)
                .commit()
        }
        // display the fragment on the portrait_frame container in portrait mode
        // display the fragment on the land_display_frame container in landscape mode
    }

    override fun onUpdateButtonClicked(movie: Movie) {
        // update the movie passed to database using viewModel
        // create DisplayContentFragment fragment using its factory method
        // display the fragment on the portrait_frame container in portrait mode
        // display the fragment on the land_display_frame container in landscape mode
        movieViewModel.update(movie)
        val bundle= Bundle()
        bundle.putSerializable("movie",movie)
        bundle.putString("title",movie.movieTitle)
        val displayContentFragment=DisplayContentFragment()
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.portrait_frame, displayContentFragment)
                .addToBackStack(null)
                .commit()
        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.land_manage_frame, displayContentFragment)
                .addToBackStack(null)
                .commit()
        }
    }
    override fun onSearch(title: String) {
       var movie= movieViewModel.getMovieBytTitle(title)

        val bundle= Bundle()
        bundle.putSerializable("movie",movie.value)
     //   bundle.putString("title",movie.)

        val displayContentFragment=DisplayContentFragment()
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.portrait_frame, displayContentFragment)
                .addToBackStack(null)
                .commit()
        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.land_manage_frame, displayContentFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDelete(title: String) {
         movieViewModel.delete(title)
    }
}
