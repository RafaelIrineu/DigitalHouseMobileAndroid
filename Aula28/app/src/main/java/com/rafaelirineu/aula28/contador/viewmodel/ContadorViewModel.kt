package com.rafaelirineu.aula28.contador.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel : ViewModel() {

    var contador = MutableLiveData<Int>().apply { value = 0 }

    /*ou usa o init:

    init{
        contador.value = 0
    }*/

    fun incrementar() {
        contador.value = contador.value!! + 1
    }
}