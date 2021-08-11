package com.study.network

//
//  ServiceBuilder.kt
//  MiniLoginApplication
//
//  Created by moon on 05/08/2021
//

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ServiceBuilder {
    private const val baseURL = "https://randomuser.me/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildService(): UserAPI{
        return retrofit.create(UserAPI::class.java)
    }
}