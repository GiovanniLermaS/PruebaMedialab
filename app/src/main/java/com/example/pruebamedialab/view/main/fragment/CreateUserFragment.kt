package com.example.pruebamedialab.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.pruebamedialab.R
import com.example.pruebamedialab.databinding.FragmentCreateUserBinding
import com.example.pruebamedialab.db.AppDatabase
import com.example.pruebamedialab.db.model.User
import kotlinx.coroutines.launch

class CreateUserFragment(val appDatabase: AppDatabase) : Fragment() {

    private var _binding: FragmentCreateUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateUserBinding.inflate(inflater, container, false)
        clickCreateUser()
        clickDeleteUser()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickCreateUser() {
        binding.btCreate.setOnClickListener {
            if (binding.etName.text.toString().isNotEmpty() && binding.etBio.text.toString()
                    .isNotEmpty() && binding.etEmail.text.toString().isNotEmpty()
            ) {
                lifecycleScope.launch {
                    appDatabase.userDao().setUser(
                        User(
                            binding.etName.text.toString(),
                            R.drawable.image,
                            binding.etBio.text.toString(),
                            binding.etEmail.text.toString()
                        )
                    )
                    Toast.makeText(activity, "Usuario creado exitosamente", Toast.LENGTH_LONG)
                        .show()
                    binding.etName.setText("")
                    binding.etBio.setText("")
                    binding.etEmail.setText("")
                }
            } else {
                Toast.makeText(activity, "Llena los campos", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun clickDeleteUser() {
        binding.btDelete.setOnClickListener {
            if (binding.etEmail.text.toString().isNotEmpty()) {
                lifecycleScope.launch {
                    val user = appDatabase.userDao().getUserByEmail(binding.etEmail.text.toString())
                    if (user.name == null) {
                        Toast.makeText(activity, "Usuario no encontrado", Toast.LENGTH_LONG).show()
                    } else {
                        appDatabase.userDao().deleteUserById(user.id)
                        Toast.makeText(
                            activity,
                            "Usuario eliminado correctamente",
                            Toast.LENGTH_LONG
                        ).show()
                        binding.etName.setText("")
                        binding.etBio.setText("")
                        binding.etEmail.setText("")
                    }
                }
            } else {
                Toast.makeText(activity, "Campo correo vacío", Toast.LENGTH_LONG).show()
            }
        }
    }
}