package com.rafaelirineu.aula36.repository

class CharacterRepository {

    private val client: CharacterEndpoint = CharacterEndpoint.endpoint

    suspend fun obterLista()= client.obterLista()
}