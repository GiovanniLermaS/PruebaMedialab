package com.example.pruebamedialab.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebamedialab.R
import com.example.pruebamedialab.databinding.ActivityDetailBinding
import com.example.pruebamedialab.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private val user by lazy { intent.getSerializableExtra("user") }

    private var binding: ActivityDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}