package com.study.miniloginapplication.domain.entity

//
//  User.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

data class Users(
    val results: ArrayList<User>
)

data class User(
    val name: String = EMPTY_STRING,
    val age: String = EMPTY_STRING,
    val gender: String = EMPTY_STRING,
    val nation: String = EMPTY_STRING,
    val email: String = EMPTY_STRING,
    val phone: String = EMPTY_STRING,
    val cell: String = EMPTY_STRING,
    val profile: String = EMPTY_STRING
) {
    companion object {
        const val EMPTY_STRING = ""
    }
}
