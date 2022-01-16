package com.example.pruebamedialab.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.pruebamedialab.databinding.FragmentListUsersBinding
import com.example.pruebamedialab.db.AppDatabase
import kotlinx.coroutines.launch

class ListUsersFragment(val appDatabase: AppDatabase) : Fragment() {

    private var _binding: FragmentListUsersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListUsersBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            val listUsers = appDatabase.userDao().getUsers()
            if(listUsers.isNotEmpty()){

            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}