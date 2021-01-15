package com.rafaelirineu.exercicioapiaula35.category.repository

import com.rafaelirineu.exercicioapiaula35.utils.NetworkUtils
import retrofit2.http.GET

interface CategoryEndPoint {
    @GET("categories")
    suspend fun categories(): List<String>

    companion object {
        val endpoint: CategoryEndPoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoryEndPoint::class.java)
        }
    }
}