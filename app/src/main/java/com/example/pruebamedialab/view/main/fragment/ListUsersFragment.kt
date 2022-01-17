package com.example.pruebamedialab.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.pruebamedialab.databinding.FragmentListUsersBinding
import com.example.pruebamedialab.db.AppDatabase
import com.example.pruebamedialab.db.model.User
import com.example.pruebamedialab.view.main.adapter.ListUsersAdapter

class ListUsersFragment(
    private val appDatabase: AppDatabase,
    private val lifecycleOwner: LifecycleOwner
) : Fragment() {

    private var _binding: FragmentListUsersBinding? = null
    private val binding get() = _binding!!
    private var listUsersAdapter: ListUsersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListUsersBinding.inflate(inflater, container, false)
        getUsersShowList()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getUsersShowList() {
        appDatabase.userDao().getUsersLiveData().observe(lifecycleOwner, { listUsers ->
            if (listUsers.isNotEmpty()) {
                if (listUsersAdapter == null) {
                    listUsersAdapter =
                        activity?.let { ListUsersAdapter(listUsers as ArrayList<User>, it) }
                    binding.rvListUsers.adapter = listUsersAdapter
                } else {
                    listUsersAdapter?.setItems(listUsers as ArrayList<User>)
                }
            }
        }
        )
    }
}