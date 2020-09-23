package com.mallich.kotlinpracticeapp.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

    companion object {

        @Volatile
        private var instance : UserDatabase ?= null
        private val LOCK = Any()

        operator fun invoke(application: Application) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(application).also {
                instance = it
            }
        }

        private fun buildDatabase(application: Application) = Room.databaseBuilder(
            application,
            UserDatabase::class.java,
            "Users"
        ).build()

    }

}