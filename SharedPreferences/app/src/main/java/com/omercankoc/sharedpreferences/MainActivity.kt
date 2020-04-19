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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Definition:
    var name : String? = null
    var surname : String? = null

    // Shared Preference Definition:
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definition and Initialize:
        val editTextName : EditText = findViewById(R.id.editTextName)
        val editTextSurname : EditText = findViewById(R.id.editTextSurname)
        val textViewMessage : TextView = findViewById(R.id.textViewMessage)
        val buttonSave : Button = findViewById(R.id.buttonSave)
        val buttonDelete : Button = findViewById(R.id.buttonDelete)

        // Shared Preference Initialize:
        //SharedPreferences : Kucuk verileri kaydetmek icin key-value prensibi ile calisan yapi.
        sharedPreferences = this.getSharedPreferences("com.omercankoc.sharedpreferences",
            Context.MODE_PRIVATE)

        // Shared Preferences ile tutulan verilerin get operasyonu.
        name = sharedPreferences.getString("name","")
        surname = sharedPreferences.getString("surname","")

        if(name != "" && surname != ""){
            textViewMessage.text = "Hello $name $surname"
        }
        else{
            Toast.makeText(this,"NULL!",Toast.LENGTH_LONG).show()
        }
    }

    fun onClickSave(view : View){
        name = editTextName.text.toString()
        surname = editTextSurname.text.toString()

        if (name != "" && surname != ""){
            textViewMessage.text = "Hello $name $surname"

            // Key-Value veri yapısı ile edit(put) operasyonu.
            sharedPreferences!!.edit().putString("name",name).apply()
            sharedPreferences!!.edit().putString("surname",surname).apply()
            // apply() ve commit() arasindaki fark:
            //
        }
        else
        {
            Toast.makeText(this,"NULL!",Toast.LENGTH_LONG).show()
        }
    }

    fun onClickDelete(view : View){

        name = sharedPreferences.getString("name","")
        surname = sharedPreferences.getString("surname","")

        if(name != "" && surname != ""){
            sharedPreferences.edit().remove("name").apply()
            sharedPreferences.edit().remove("surname").apply()
            textViewMessage.text = "Data is removed!"
        }
        else{
            Toast.makeText(this,"NULL!",Toast.LENGTH_LONG).show()
        }
    }
}
