package com.mallich.kotlinpracticeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.mallich.kotlinpracticeapp.databinding.RowBinding
import com.mallich.kotlinpracticeapp.room.User

class UserAdapter(private val allUsers: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowBinding : RowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row, parent, false)
        return ViewHolder(rowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = allUsers[position]
        holder.rowBinding.user = user
    }

    override fun getItemCount(): Int {
        return allUsers.size
    }

    class ViewHolder(itemView: RowBinding) : RecyclerView.ViewHolder(itemView.root) {
        val rowBinding = itemView
    }

}