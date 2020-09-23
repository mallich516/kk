package com.mallich.kotlinpracticeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mallich.kotlinpracticeapp.databinding.ActivityMainBinding
import com.mallich.kotlinpracticeapp.room.User
import kotlin.time.ExperimentalTime

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    @ExperimentalTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.getAllUsers().observe(this, Observer { usersList ->
            val userAdapter = UserAdapter(usersList)
            binding.recyclerView.adapter = userAdapter
            Toast.makeText(this, "Hello World!", Toast.LENGTH_LONG).show()
        })

        binding.fab.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }

    }

}