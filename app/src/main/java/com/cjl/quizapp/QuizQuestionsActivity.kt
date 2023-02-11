package com.cjl.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var myCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var btnSubmit: Button? = null


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

        btnSubmit = findViewById(R.id.btnSubmit)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }


    private fun setQuestion() {

        val question: Question = mQuestionsList!![myCurrentPosition - 1]

        ivImage?.setImageResource(question.image)

        progressBar?.progress = myCurrentPosition
        tvProgressBar?.text = "$myCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        tvOptionOne?.text = question.optionOne
        tvOptionFour?.text = question.optionFour
        tvOptionTwo?.text = question.optionOTwo
        tvOptionThree?.text = question.optionThree

        if(myCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }else {
            btnSubmit?.text = "SUBMIT"
        }


        

    }





    override fun onClick(p0: View?) {
        TODO("Not yet implemented")


    }
}