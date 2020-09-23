package com.mallich.kotlinpracticeapp

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.mallich.kotlinpracticeapp.room.User
import com.mallich.kotlinpracticeapp.room.UserDao
import com.mallich.kotlinpracticeapp.room.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(
    application: Application,
    userDatabase: UserDatabase = UserDatabase.invoke(application)
) {

    private val userDao: UserDao = userDatabase.getUserDao()
    private val allUsers: MutableLiveData<List<User>> = userDatabase.getUserDao().getAllUsers()

    fun insertUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch { userDao.insertUser(user) }
    }

    fun updateUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch { userDao.updateUser(user) }
    }

    fun deleteUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch { userDao.deleteUser(user) }
    }

    fun getUser(userId: Int): MutableLiveData<User> {
        return userDao.getUser(userId)
    }

    @JvmName("getAllUsers1")
    fun getAllUsers(): MutableLiveData<List<User>> {
        return allUsers
    }
}