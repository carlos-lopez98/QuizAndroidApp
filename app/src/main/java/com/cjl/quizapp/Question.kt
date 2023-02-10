package com.cjl.quizapp

//Data Class must have at least one primary parameter
//Data class cannot be open, sealed or inner classes
//Saves boiler plate code as long as you pass in the parameters
data class Question(
    val id: Int,
    val questions: String,
    val image: Int,

    val optionOne: String,
    val optionOTwo: String,
    val optionThree: String,
    val optionFour: String,

    val correctAnswer: Int
    )


