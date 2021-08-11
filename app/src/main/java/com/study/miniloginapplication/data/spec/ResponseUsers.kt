package com.study.miniloginapplication.data.spec

//
//  R_Users.kt
//  MiniLoginApplication
//
//  Created by moon on 06/08/2021
//

data class ResponseUsers(
    val results: ArrayList<User>
)

data class User(
    val name: Name,
    val dob: Age,
    val gender: String,
    val nat: String,
    val email: String,
    val phone: String,
    val cell: String,
    val location: Location,
    val picture: Picture
)

data class Name(val first: String, val last: String)
data class Age(val age: Int)
data class Location(val city: String, val country: String, val coordinates: Coordinates)
data class Coordinates(val latitude: String, val longitude: String)
data class Picture(val large: String)
