package com.cjl.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {


    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progress_bar)
        tvProgressBar = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.iv_image)

        tvOptionOne = findViewById(R.id.iv_optionOne)
        tvOptionTwo = findViewById(R.id.iv_optionTwo)
        tvOptionThree = findViewById(R.id.iv_optionThree)
        tvOptionFour = findViewById(R.id.iv_optionFour)


    val questionsList = Constants.getQuestions()
        Log.i("QuestionsList size is", "${questionsList.size}")

        for(i in questionsList){
            println("Question is ${i.question}")
        }

        var currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]

        ivImage?.setImageResource(question.image)

        progressBar?.progress = currentPosition
        tvProgressBar?.text = "$currentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        tvOptionOne?.text = question.optionOne
        tvOptionFour?.text = question.optionFour
        tvOptionTwo?.text = question.optionOTwo
        tvOptionThree?.text = question.optionThree
    }
}