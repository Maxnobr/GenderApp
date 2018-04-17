package com.vogella.android.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {

    var male = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        val ml = findViewById<RadioButton>(R.id.male)
        ml.alpha = .5f

        gender.setOnCheckedChangeListener({ radioGroup: RadioGroup, i: Int ->
            val ml = radioGroup.findViewById<RadioButton>(R.id.male)
            val fl = radioGroup.findViewById<RadioButton>(R.id.female)
            ml.alpha = 1f
            fl.alpha = 1f

            if(i == (R.id.male)) {
                male = true
                ml.alpha = .5f
            }
            else if (i == (R.id.female)) {
                male = false
                fl.alpha = .5f
            }
            //Log.i("gender","$male")
        })
    }

    fun onClick(view: View) {
        //Log.i("onClick","clicked!")
        val input = findViewById<EditText>(R.id.username)
        val string = input.text
        Toast.makeText(this,(if(male)"Male: ";else "Female") +": User $string created.",Toast.LENGTH_LONG).show()
        //val string: String = input.getText().toString()
        //Toast.makeText(this, "User " + string + " created.", Toast.LENGTH_LONG).show()
    }
}
