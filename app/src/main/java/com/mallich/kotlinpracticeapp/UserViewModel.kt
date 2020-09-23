package com.mallich.kotlinpracticeapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mallich.kotlinpracticeapp.room.User

class UserViewModel(application: Application) : AndroidViewModel(application) {

    var userRepository : UserRepository = UserRepository(application)
    private val allUsers : MutableLiveData<List<User>> = userRepository.getAllUsers()

    fun insertUser(user: User) {
        userRepository.insertUser(user)
    }

    fun updateUser(user: User) {
        userRepository.updateUser(user)
    }

    fun deleteUser(user: User) {
        userRepository.deleteUser(user)
    }

    fun getUser(userId : Int) : MutableLiveData<User> {
        return userRepository.getUser(userId)
    }
    @JvmName("getAllUsers1")
    fun getAllUsers(): MutableLiveData<List<User>> {
        return allUsers
    }
}