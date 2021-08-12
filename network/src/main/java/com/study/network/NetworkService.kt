package com.study.network

//
//  NetworkService.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import retrofit2.Call

object NetworkService {
    fun<T> requestNetwork(requestCall: Call<T>): T? {
        requestCall.execute().apply {
            return if (isSuccessful) {
                body()
            } else {
                null
            }
        }
    }
}