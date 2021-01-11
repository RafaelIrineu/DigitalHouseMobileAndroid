package com.rafaelirineu.aula36.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

        companion object{
            fun getRetrofitInstance(baseurl: String = BASE_URL): Retrofit = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            private const val BASE_URL = "https://www.breakingbadapi.com/api/"
    }
}

