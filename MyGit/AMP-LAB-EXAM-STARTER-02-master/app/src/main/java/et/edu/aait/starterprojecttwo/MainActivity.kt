package et.edu.aait.starterprojecttwo


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

const private val TEXT_KEY="text_id"
const private val SHARED_PREF_FILE_NAME="shared_preference_id"

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref:SharedPreferences
    private lateinit var editText:EditText
    private lateinit var textView:TextView
    private lateinit var loadButton:Button
    private lateinit var saveButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref=getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)

        editText=edit_text
        loadButton=load_button
        saveButton=save_button
        textView=text_view
        loadButton.setOnClickListener {
          load()
        }
        saveButton.setOnClickListener {

            save(Integer.parseInt(editText.text.toString()))
        }

    }

    fun save(intValue:Int){
        with(sharedPref.edit()){
            putInt(TEXT_KEY,intValue)
            commit()
        }
    }
   fun load(){
       textView.text=sharedPref.getInt(TEXT_KEY,4).toString()
   }

}
