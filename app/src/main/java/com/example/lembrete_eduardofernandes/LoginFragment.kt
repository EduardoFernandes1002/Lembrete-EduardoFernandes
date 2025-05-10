package com.example.lembrete_eduardofernandes



import android.view.LayoutInflater
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lembrete_eduardofernandes.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContinuar.setOnClickListener{

            val nome = binding.txtInputNome.text.toString()
            val sobrenome = binding.txtInputSobrenome.text.toString()

            if (nome.isNotEmpty() && sobrenome.isNotEmpty()) {

                val nomeCompleto = "Olá, " + nome + " " + sobrenome

                val bundle = Bundle().apply {
                    putString("NOME_DIGITADO", nomeCompleto)
                }
                findNavController().navigate(R.id.action_login_to_lembrete, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}