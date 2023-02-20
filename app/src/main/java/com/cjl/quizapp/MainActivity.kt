package com.cjl.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btn_start)

        val edName: EditText = findViewById(R.id.ed_name)
        //Check to see if user has entered text -- if empty don't start the game
        //If it has something valid then proceed to QuizActivity

        btnStart.setOnClickListener(){

            if(edName.text.isEmpty()){
                Toast.makeText(this, "Please enter a name!", Toast.LENGTH_LONG).show()
            } else{
                //Create an intent to move to a different screeen -- The intent is basically the instructions
                //On what you want our button to do -- the startActivity takes the intent, which runs the intent
                val intent: Intent = Intent(this, QuizQuestionsActivity::class.java)

                intent.putExtra(Constants.USER_NAME, edName.text.toString())
                startActivity(intent)

                //Closes current activity
            }
        }
    }
}