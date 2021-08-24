package com.study.miniloginapplication.data.datasource

//
//  UserDataSourceImpl.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.google.gson.Gson
import com.study.miniloginapplication.data.spec.ResponseUsers
import com.study.network.ServiceBuilder

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUserList(size: Int): ResponseUsers? {
        val gson = Gson()
        val service = ServiceBuilder.buildService()
        return gson.fromJson(service.getUsers(size), ResponseUsers::class.java)
    }
}
