package com.rafaelirineu.aula36.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.rafaelirineu.aula36.model.CharacterModel
import com.rafaelirineu.aula36.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel(private val repository: CharacterRepository): ViewModel() {

    private var _characters: List<CharacterModel> = listOf()

    fun obterLista(): LiveData<List<CharacterModel>> = liveData(Dispatchers.IO) {
        val response = repository.obterLista()
        _characters = response

        emit(response)
    }

    class CharacterViewModelFactory(
        private val repository: CharacterRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }

}