package com.study.miniloginapplication.domain.usecase

//
//  GetUserListUseCaseImpl.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.study.miniloginapplication.domain.UserRepository
import com.study.miniloginapplication.domain.entity.Users

class GetUserListUseCaseImpl(
    private val userRepository: UserRepository
) : GetUserListUseCase {
    override suspend fun invoke(size: Int): Users? {
        return userRepository.getUserList(size)
    }
}
