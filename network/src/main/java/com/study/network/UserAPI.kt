package com.study.network

//
//  UserAPI.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import retrofit2.http.*

interface UserAPI {
    @GET("/api")
    suspend fun getUsers(@Query("results") key: Int): String
}