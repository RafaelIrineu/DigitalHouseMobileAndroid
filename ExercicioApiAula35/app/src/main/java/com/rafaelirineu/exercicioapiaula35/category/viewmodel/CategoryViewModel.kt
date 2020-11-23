package com.rafaelirineu.exercicioapiaula35.category.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rafaelirineu.exercicioapiaula35.category.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher

class CategoryViewModel(private val _repository: CategoryRepository): ViewModel()  {

    fun obtainCategories() = liveData(Dispatchers.IO) {
        val response = _repository.categories()
        emit(response)
    }



}