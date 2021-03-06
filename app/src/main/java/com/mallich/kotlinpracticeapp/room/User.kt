package com.mallich.kotlinpracticeapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    val userName: String,

    val email: String,

    val password: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}