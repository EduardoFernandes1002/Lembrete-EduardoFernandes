package com.example.lembrete_eduardofernandes

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.lembrete_eduardofernandes.databinding.ActivityMainBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth

class MainActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        val sharedPref = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        val token = sharedPref.getString("token", "")

        if (!token.isNullOrEmpty()) {
            val userToken = auth.currentUser?.getIdToken(true)
            if (token.toString() == userToken.toString()) {
            }
        }


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}