package com.mallich.kotlinpracticeapp.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM User WHERE id=:userId")
    fun getUser(userId: Int): MutableLiveData<User>

    @Query("SELECT * FROM User")
    fun getAllUsers(): MutableLiveData<List<User>>

    @Query("SELECT id from User ORDER BY id DESC limit 1")
    suspend fun getLastId(): MutableLiveData<Int>

}