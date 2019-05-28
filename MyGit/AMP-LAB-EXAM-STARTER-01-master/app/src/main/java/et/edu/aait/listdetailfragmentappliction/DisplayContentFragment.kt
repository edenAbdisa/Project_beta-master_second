package et.edu.aait.listdetailfragmentappliction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import et.edu.aait.listdetailfragmentappliction.data.Movie
import kotlinx.android.synthetic.main.fragment_display_content.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DisplayContentFragment() : Fragment() {
    private lateinit var movieDAO:MovieDAO
    private lateinit var movieRepo:MovieRepository
    private lateinit var viewModelScope: CoroutineScope
    private lateinit var movie:Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_display_content, container, false)

        val myViewModel=ViewModelProviders.of(this).get(MovieViewModel::class.java)
        var movie=savedInstanceState?.getBundle("movie")
         viewModelScope.launch(Dispatchers.IO){
            displayMovie(view,movie as Movie)
        }

        return view
    }
    private fun displayMovie(view:View,mov:Movie){
        view.textView_title.text=mov.movieTitle
        view.textView_category.text=mov.category
        view.textView_description.text=mov.description

    }

}
