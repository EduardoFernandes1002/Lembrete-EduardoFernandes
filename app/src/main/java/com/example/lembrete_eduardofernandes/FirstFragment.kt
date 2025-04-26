package com.example.lembrete_eduardofernandes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lembrete_eduardofernandes.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private lateinit var context: Context

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context = requireContext()

        val sharedP = context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val edit = sharedP.edit()

        val lembrete = sharedP.getString("texts", "Sem lembrete")

        binding.textInputEditText.setText(lembrete.toString())

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