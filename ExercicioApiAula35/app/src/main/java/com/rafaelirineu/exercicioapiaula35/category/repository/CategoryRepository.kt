package com.rafaelirineu.exercicioapiaula35.category.repository

class CategoryRepository {
    private val _client = CategoryEndPoint.endpoint

    suspend fun obterCategoria() = _client.categories()
}