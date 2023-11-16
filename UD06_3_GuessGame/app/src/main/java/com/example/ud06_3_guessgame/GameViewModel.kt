package com.example.ud06_3_guessgame

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    val words = listOf("Android", "Fragment", "Kotlin", "Model")
    var secretWord = words.random().uppercase()
}