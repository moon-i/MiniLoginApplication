package com.study.network

//
//  ServiceBuilder.kt
//  MiniLoginApplication
//
//  Created by moon on 05/08/2021
//

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val baseURL = "https://randomuser.me/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}