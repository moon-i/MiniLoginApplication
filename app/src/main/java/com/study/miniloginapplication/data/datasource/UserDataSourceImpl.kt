package com.study.miniloginapplication.data.datasource

//
//  UserDataSourceImpl.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.study.miniloginapplication.data.spec.ResponseUsers
import com.study.network.RequestMapper

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUserList(size: Int): ResponseUsers? {
        return RequestMapper().getUsers(size, ResponseUsers::class.java)
    }
}
