package com.example.pruebamedialab.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebamedialab.R
import com.example.pruebamedialab.db.model.User


class ListUsersAdapter(private var users: ArrayList<User>) :
    RecyclerView.Adapter<ListUsersAdapter.ViewHolder>() {

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_user, parent, false) as TextView
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.view
        val user = users[position]
        user.image?.let {
            view.findViewById<ImageView>(R.id.ivUser).setImageResource(
                it
            )
        }
        view.findViewById<TextView>(R.id.tvName).text = user.name
        view.findViewById<TextView>(R.id.tvBioUser).text = user.bio
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setItems(users: ArrayList<User>){
        this.users = users
    }
}