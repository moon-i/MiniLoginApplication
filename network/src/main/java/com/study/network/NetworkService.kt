package com.study.network

//
//  NetworkService.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import retrofit2.Call

object NetworkService {
    fun requestNetwork(requestCall: Call<String>): String? {
        requestCall.execute().apply {
            return if (isSuccessful) {
                body()
            } else {
                null
            }
        }
    }
}