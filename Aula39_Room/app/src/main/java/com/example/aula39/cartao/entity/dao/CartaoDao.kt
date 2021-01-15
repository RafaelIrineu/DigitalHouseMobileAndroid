package com.example.aula39.cartao.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aula39.cartao.entity.CartaoEntity

@Dao
interface CartaoDao {

    @Insert
    suspend fun addCartao(cartao: CartaoEntity)

    @Query("SELECT COUNT (*) FROM Cartao")
    suspend fun count(): Int
}