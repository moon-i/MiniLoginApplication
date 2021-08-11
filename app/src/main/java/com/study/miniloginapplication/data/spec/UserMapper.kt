package com.study.miniloginapplication.data.spec

//
//  UserMapper.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

import com.study.miniloginapplication.domain.entity.User
import com.study.miniloginapplication.domain.entity.Users

object UserMapper {
    fun mapToEntity(spec: ResponseUsers): Users {
        val userList = arrayListOf<User>()

        for (user in spec.results) {
            userList.add(
                User(
                    name = "${user.name.last} ${user.name.first}",
                    age = "(${user.dob.age})",
                    gender = when (user.gender) {
                        "male" -> "\uD83D\uDE4B\u200D\u2642\uFE0F"
                        else -> "\uD83D\uDE4B\u200D\u2640\uFE0F"
                    },
                    nation = "\uD83C\uDDFA\uD83C\uDDF8",
                    email = user.email,
                    phone = user.phone,
                    cell = user.cell,
                    profile = user.picture.large
                )
            )
        }

        return Users(userList)
    }
}
