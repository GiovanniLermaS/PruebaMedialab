package com.example.pruebamedialab.view.main.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebamedialab.R
import com.example.pruebamedialab.db.model.User
import com.example.pruebamedialab.view.detail.DetailActivity


class ListUsersAdapter(private var users: ArrayList<User>, private val activity: Activity) :
    RecyclerView.Adapter<ListUsersAdapter.ViewHolder>() {

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_user, parent, false)
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
        clickStartActivity(view, user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setItems(users: ArrayList<User>) {
        this.users.clear()
        this.users.addAll(users)
        this.notifyDataSetChanged()
    }

    private fun clickStartActivity(view: View, user: User) {
        view.setOnClickListener {
            val intent = Intent(
                activity,
                DetailActivity::class.java
            )
            intent.putExtra("user", user)
            activity.startActivity(
                intent
            )
        }
    }
}