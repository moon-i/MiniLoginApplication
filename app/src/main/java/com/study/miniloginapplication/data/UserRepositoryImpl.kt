package com.study.miniloginapplication.data

//
//  UserRepositoryImpl.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.study.miniloginapplication.data.datasource.UserDataSource
import com.study.miniloginapplication.data.spec.UserMapper
import com.study.miniloginapplication.domain.UserRepository
import com.study.miniloginapplication.domain.entity.Users

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUserList(size: Int): Users? {
        userDataSource.getUserList(size)?.let { responseData ->
            return UserMapper.mapToEntity(responseData)
        } ?: run {
            return null
        }
    }
}
