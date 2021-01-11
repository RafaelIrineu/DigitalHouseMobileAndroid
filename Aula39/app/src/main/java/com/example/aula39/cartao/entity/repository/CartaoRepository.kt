package com.example.aula39.cartao.entity.repository

import com.example.aula39.cartao.entity.CartaoEntity
import com.example.aula39.cartao.entity.dao.CartaoDao

class CartaoRepository(private val cartaoDao: CartaoDao) {

    suspend fun addCartao(cartao: CartaoEntity) = cartaoDao.addCartao(cartao)
    suspend fun count() = cartaoDao.count()
}