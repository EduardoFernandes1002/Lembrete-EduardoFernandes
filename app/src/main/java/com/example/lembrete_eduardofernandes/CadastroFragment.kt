package com.example.lembrete_eduardofernandes


import android.view.LayoutInflater
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lembrete_eduardofernandes.databinding.FragmentCadastroBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth

class CadastroFragment : Fragment() {
    private var _binding: FragmentCadastroBinding? = null

    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        auth = Firebase.auth
        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVoltarLogin.setOnClickListener {
            findNavController().navigate(R.id.action_cadastro_to_login)
        }

        binding.btnCadastrar.setOnClickListener {

            val email = binding.editTxtEmailCadastro.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("DEBUG", "createUserWithEmail:success")
                        findNavController().navigate(R.id.action_cadastro_to_login)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("WARNING", "createUserWithEmail:failure", task.exception)
                    }
                }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}