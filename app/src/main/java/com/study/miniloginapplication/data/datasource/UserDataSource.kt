package com.study.miniloginapplication.data.datasource

//
//  UserDataSource.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.study.miniloginapplication.data.spec.ResponseUsers

interface UserDataSource {
    suspend fun getUserList(size: Int): ResponseUsers?
}
