package com.example.pruebamedialab.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pruebamedialab.R
import com.example.pruebamedialab.databinding.ActivityMainBinding
import com.example.pruebamedialab.db.AppDatabase
import com.example.pruebamedialab.view.main.adapter.AdapterViewPager
import com.example.pruebamedialab.view.main.fragment.CreateUserFragment
import com.example.pruebamedialab.view.main.fragment.ListUsersFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setFragments()
    }

    private fun setFragments() {
        val listFragments = ArrayList<Fragment>()
        listFragments.add(ListUsersFragment(appDatabase, this))
        listFragments.add(CreateUserFragment(appDatabase))
        val listTitleFragments = ArrayList<String>()
        listTitleFragments.add("Lista usuarios")
        listTitleFragments.add("Crear usuario")
        val adapterViewPager =
            AdapterViewPager(supportFragmentManager, listFragments, listTitleFragments)
        binding?.vpFragment?.adapter = adapterViewPager
        binding?.tabLayout?.setupWithViewPager(binding?.vpFragment)
    }
}