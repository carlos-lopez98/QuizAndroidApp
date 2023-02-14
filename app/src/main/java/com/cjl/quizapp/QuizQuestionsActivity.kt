package com.cjl.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

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

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
    }

    /**
     * Set's the Question Screen along with the question that is being displayed
     */
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

    /**
     * Set's the default view of the buttons, all light grey
     */
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        tvOptionOne?.let{
            options.add(0, it)
        }
        tvOptionTwo?.let{
            options.add(1, it)
        }
        tvOptionThree?.let{
            options.add(2, it)
        }
        tvOptionFour?.let{
            options.add(3, it)
        }
//     Looping through all our option view, selecting them and setting their UI properties
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    /**
     * Set's the view for the option the user has currently selected
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView() // Sets every button to it's normal look

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    /**
     * Set's what happens on click for our clickable components
     *
     * IE. If tvOptionOne is clicked, border == purple
     *
     * IE. If submitBtn is clicked, move to next question, also let's you know if you're selectedOption is correct or wrong
     */
    override fun onClick(view: View?) {

        when(view?.id){
            R.id.iv_optionOne -> {
                tvOptionOne?.let{
                    selectedOptionView(it, 1)
                }
            }
            R.id.iv_optionTwo -> {
                tvOptionTwo?.let{
                    selectedOptionView(it, 2)
                }
            }
            R.id.iv_optionThree -> {
                tvOptionThree?.let{
                    selectedOptionView(it, 3)
                }
            }
            R.id.iv_optionFour -> {
                tvOptionFour?.let{
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit -> {

                if(mSelectedOptionPosition == 0){
                    myCurrentPosition++

                    when{
                        myCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                    }
                } else{
                    val question = mQuestionsList?.get(myCurrentPosition - 1)

                    //If selected answer is incorrect, on submit click option will turn red
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                }




            }
        }
    }

    /**
     * Takes in the answer that the user selected
     *
     * If correct, we'll assign it green, if incorrect we'll assign it red
     */
    private fun answerView(answer: Int, drawableView: Int){

        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }


    }
}