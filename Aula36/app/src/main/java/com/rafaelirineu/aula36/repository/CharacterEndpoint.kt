package com.rafaelirineu.aula36.repository

import com.rafaelirineu.aula36.model.CharacterModel
import com.rafaelirineu.aula36.network.NetworkUtils
import retrofit2.http.GET

interface CharacterEndpoint {
    @GET("characters")
    suspend fun obterLista(): List<CharacterModel>

    companion object{
        val endpoint:CharacterEndpoint by lazy{
            NetworkUtils.getRetrofitInstance().create(CharacterEndpoint::class.java)
        }
    }
}