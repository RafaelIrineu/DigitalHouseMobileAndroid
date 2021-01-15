package com.rafaelirineu.exercicioaula28.viewmodel

import androidx.lifecycle.ViewModel
import com.rafaelirineu.exercicioaula28.repository.TarefaRepository

class TarefaViewModel (
    private val repository:TarefaRepository
): ViewModel(){
}