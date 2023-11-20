package com.example.ud06_3_guessgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    val words = listOf("Android", "Fragment", "Kotlin", "Model")
    var secretWord = words.random().uppercase()
    //Palabra que voy a mostrar
    //var secretWordDisplay =""
    var secretWordDisplay = MutableLiveData<String>()
    //Número de vidas
    //var lives = 5
    var lives = MutableLiveData<Int>(5)
    //Intentos del usuario. Carecteres
    var guesses = mutableListOf<Char>()

    init {
        secretWordDisplay.value =  generateWordDisplay()
    }
    fun generateWordDisplay() =
        secretWord.map {
            if(it in guesses) it
                else "_"
        }.joinToString("")

    fun game(guess : Char){
        //Añado el caracter a la lista de intentos
        guesses.add(guess.uppercaseChar())
        //Actualizo la palabra a mostrar
        secretWordDisplay.value = generateWordDisplay()
        //Actualizado las vidas
        if(!secretWord.contains(guess.uppercaseChar())) lives.value?.toInt()?.minus(1)
    }

    fun win() =  secretWord.equals(secretWordDisplay)
    fun lost() = lives.value?:0 <= 0

    fun resultMessage() =
        if (win()) "Ganaste la palabra secreta era $secretWord"
        else "Opps, perdiste la palabra secreta era $secretWord"

    fun restart(){
        guesses.clear()
        lives.value = 5
        secretWord = words.random().uppercase()
        secretWordDisplay.value = generateWordDisplay()
    }

}