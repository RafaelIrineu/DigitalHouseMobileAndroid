package com.example.aula39.cartao.entity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.aula39.cartao.entity.CartaoEntity
import com.example.aula39.cartao.entity.repository.CartaoRepository
import kotlinx.coroutines.Dispatchers

class CartaoViewModel(private val repository: CartaoRepository): ViewModel() {

    fun addCartao(cartao: CartaoEntity) = liveData(Dispatchers.IO) {
        repository.addCartao(cartao)
        emit(true)
    }
    fun count() = liveData(Dispatchers.IO){
        val count = repository.count()
        emit(count)
    }

    class CartaoViewModelFactory(private val repository: CartaoRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CartaoViewModel(repository) as T
        }
    }
}