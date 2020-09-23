package com.mallich.kotlinpracticeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.mallich.kotlinpracticeapp.databinding.ActivityMain2ActivtyBinding
import com.mallich.kotlinpracticeapp.room.User

class Main2Activity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2ActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root
        )
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.saveBtn.setOnClickListener {
            val name = binding.username.text.toString().trim()
            val pwd = binding.email.text.toString().trim()
            val mail = binding.email.text.toString().trim()

            if (name.isEmpty() || pwd.isEmpty() || mail.isEmpty()) {
                Snackbar.make(it, "Please Enter User Details", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val user = User(name, mail, pwd)
            userViewModel.insertUser(user)

            binding.email.text = null
            binding.username.text = null
            binding.password.text = null

            Snackbar.make(it, "User Saved!", Snackbar.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}