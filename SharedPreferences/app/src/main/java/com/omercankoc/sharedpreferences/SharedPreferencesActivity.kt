package com.omercankoc.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    // Definition UIs :
    lateinit var editTextName : EditText
    lateinit var editTextSurname : EditText
    lateinit var textViewMessage : TextView
    lateinit var buttonSave : Button
    lateinit var buttonDelete : Button

    // Definition Variables :
    private var name : String? = null
    private var surname : String? = null

    // Definition Shared Preference :
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        // Initialize UIs:
        editTextName = findViewById(R.id.editTextName)
        editTextSurname = findViewById(R.id.editTextSurname)
        textViewMessage = findViewById(R.id.textViewMessage)
        buttonSave = findViewById(R.id.buttonSave)
        buttonDelete = findViewById(R.id.buttonDelete)

        // Initialize Shared Preference :
        sharedPreferences = this.getSharedPreferences("com.omercankoc.sharedpreferences",Context.MODE_PRIVATE)
        
        // Get data in Shared Preferences.
        name = sharedPreferences.getString("name","")
        surname = sharedPreferences.getString("surname","")
        if(name != "" && surname != ""){
            textViewMessage.text = "Hello $name $surname"
        } else {
            textViewMessage.text = "Hello!"
            Toast.makeText(this,"NULL!",Toast.LENGTH_LONG).show()
        }
    }

    fun onClickSave(view : View){
        name = editTextName.text.toString()
        surname = editTextSurname.text.toString()
        if (name != "" && surname != ""){
            textViewMessage.text = "Hello $name $surname"
            // Edit(put) data in Shared Preferences.
            sharedPreferences!!.edit().putString("name",name).apply()
            sharedPreferences!!.edit().putString("surname",surname).apply()
        } else {
            Toast.makeText(this,"NULL!",Toast.LENGTH_LONG).show()
        }
    }

    fun onClickDelete(view : View){
        // Get data in Shared Preferences.
        name = sharedPreferences.getString("name","")
        surname = sharedPreferences.getString("surname","")
        if(name != "" && surname != ""){
            // Edit(remove) data in Shared Preferences.
            sharedPreferences.edit().remove("name").apply()
            sharedPreferences.edit().remove("surname").apply()
            textViewMessage.text = "Data is removed!"
        } else {
            Toast.makeText(this,"NULL!",Toast.LENGTH_LONG).show()
        }
    }
}
