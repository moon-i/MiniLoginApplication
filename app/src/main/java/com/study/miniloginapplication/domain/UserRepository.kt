package com.study.miniloginapplication.domain

//
//  UserRepository.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.study.miniloginapplication.domain.entity.Users

interface UserRepository {
    suspend fun getUserList(size: Int): Users?
}
