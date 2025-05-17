package com.example.lembrete_eduardofernandes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lembrete_eduardofernandes.databinding.FragmentLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginFragment : Fragment() {

    private lateinit var context: Context

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        findNavController().navigate(R.id.action_login_to_lembrete)

        context = requireContext()

        auth = Firebase.auth
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedP = context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val edit = sharedP.edit()

        val legal = sharedP.getString("token", "noTokens")

        binding.btnLogin.setOnClickListener {

            val email = binding.editTxtEmail.text.toString()
            val password = binding.editTxtPassword.text.toString()
            val task = auth.signInWithEmailAndPassword(email, password)

            if (task.isSuccessful){
                val user = auth.currentUser
                user?.getIdToken(true)?.addOnCompleteListener { tokenTask ->
                    if(tokenTask.isSuccessful) {
                        val idToken = tokenTask.result?.token
                        if(!idToken.isNullOrEmpty()){
                            edit.putString("tokens", idToken).apply()
                            findNavController().navigate(R.id.action_login_to_lembrete)
                        }
                    } else {
                        val exception = task.exception
                    }
                }
            }
        }

        binding.btnCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_cadastro)
        }
    }
}

