package et.edu.aait.listdetailfragmentappliction

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import et.edu.aait.listdetailfragmentappliction.data.Movie
import kotlinx.android.synthetic.main.fragment_manage_content.view.*

class ManageContentFragment : Fragment() {

    private lateinit var contentOneTextTitle: EditText
    private lateinit var contentTwoTextCategory: EditText
    private lateinit var contentThreeTextDescription: EditText
    private lateinit var searchContentText: EditText

    private lateinit var addButton: Button
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button

    private lateinit var listener: OnManageButtonsClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnManageButtonsClicked){
            listener = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_manage_content, container, false)
        contentOneTextTitle=view.title
        contentTwoTextCategory= view.category
        contentThreeTextDescription=view.description
        searchContentText=view.search_content_by_title

        val addButton=view.add_button
        val deleteButton=view.delete_button
        val updateButton=view.update_button
        val searchButton=view.search_button

        addButton.setOnClickListener { listener }
        deleteButton.setOnClickListener { listener }
        updateButton.setOnClickListener { listener }
        searchButton.setOnClickListener { listener }

        listener.onAddButtonClicked(readFields())
        listener.onUpdateButtonClicked(readFields())
        listener.onDelete(contentOneTextTitle.text.toString())
        listener.onSearch(searchContentText.text.toString())
        return view
    }

    private fun updateFields(movie: Movie){
        movie?.run{
            // update UI
           /* contentOneTextTitle.text=movie.movieTitle
            contentTwoTextCategory.text = movie.category
            contentThreeTextDescription=movie.description*/
        }
    }

    private fun readFields() = Movie(1,
       contentOneTextTitle.text.toString(),contentTwoTextCategory.text.toString(),contentThreeTextDescription.text.toString()
    )

    private fun clearFields() {
        searchContentText.setText("")
        contentOneTextTitle.setText("")
        contentTwoTextCategory.setText("")
        contentThreeTextDescription.setText("")
    }

    interface OnManageButtonsClicked{
        fun onAddButtonClicked(movie: Movie)
        fun onUpdateButtonClicked(message: Movie)
        fun onSearch(title:String)
        fun onDelete(title:String)
    }
}
