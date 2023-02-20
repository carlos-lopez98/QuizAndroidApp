package com.cjl.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class Congrats : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.congrats)


        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME).toString()
        tvScore.text = "Your Score is ${intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)}" +
                " out of ${intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)}"
    }

    fun clickMe(View: View){
        startActivity(Intent(this, MainActivity::class.java))
    }

}