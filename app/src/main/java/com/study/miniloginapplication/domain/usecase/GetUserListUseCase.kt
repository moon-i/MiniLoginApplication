package com.study.miniloginapplication.domain.usecase

//
//  GetUserListUseCase.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.study.miniloginapplication.domain.entity.Users

interface GetUserListUseCase {
    suspend operator fun invoke(size: Int): Users?
}
