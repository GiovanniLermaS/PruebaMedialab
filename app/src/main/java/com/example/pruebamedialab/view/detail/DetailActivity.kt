package com.example.pruebamedialab.view.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.pruebamedialab.R
import com.example.pruebamedialab.databinding.ActivityDetailBinding
import com.example.pruebamedialab.databinding.ActivityMainBinding
import com.example.pruebamedialab.db.AppDatabase
import com.example.pruebamedialab.db.model.User
import com.example.pruebamedialab.view.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val user by lazy { intent.getSerializableExtra("user") as User }

    private var binding: ActivityDetailBinding? = null

    @Inject
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        user.image?.let { binding?.ivUser?.setImageResource(it) }
        binding?.etName?.setText(user.name)
        binding?.etBioUser?.setText(user.bio)
        binding?.etEmail?.setText(user.email)
        binding?.btUpdateUser?.setOnClickListener {
            lifecycleScope.launch {
                user.name = binding?.etName?.text?.toString()
                user.bio = binding?.etBioUser?.text?.toString()
                user.email = binding?.etEmail?.text?.toString()
                appDatabase.userDao().updateUser(user.name, user.bio, user.email, user.id)
                startActivity(Intent(this@DetailActivity, MainActivity::class.java))
            }
        }
    }
}