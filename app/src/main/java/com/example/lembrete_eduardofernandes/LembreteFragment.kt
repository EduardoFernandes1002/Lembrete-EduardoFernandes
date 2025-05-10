package com.example.lembrete_eduardofernandes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lembrete_eduardofernandes.databinding.FragmentLembreteBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LembreteFragment : Fragment() {

    private var _binding: FragmentLembreteBinding? = null

    private lateinit var context: Context

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLembreteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context = requireContext()

        val nome = arguments?.getString("NOME_DIGITADO")

        binding.texto.setText(nome)

        val sharedP = context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val edit = sharedP.edit()

        val lembrete = sharedP.getString("texts", "Sem lembrete")

        binding.textInputEditText.setText(lembrete.toString())

        binding.btnVoltar.setOnClickListener {
            findNavController().navigate(R.id.action_lembrete_to_login)
        }

        binding.btnSalvar.setOnClickListener {
            val texto = binding.textInputEditText.text.toString()

            edit.putString("texts", texto).apply()
        }

        binding.btnDeletar.setOnClickListener{
            edit.clear().commit()
            binding.textInputEditText.text?.clear()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}