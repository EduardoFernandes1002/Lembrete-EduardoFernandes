package com.example.lembrete_eduardofernandes



import android.view.LayoutInflater
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lembrete_eduardofernandes.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {
    private var _binding: FragmentCadastroBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVoltarLogin.setOnClickListener {
            findNavController().navigate(R.id.action_cadastro_to_login)
        }

        binding.btnCadastrar.setOnClickListener{


            findNavController().navigate(R.id.action_cadastro_to_login)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}