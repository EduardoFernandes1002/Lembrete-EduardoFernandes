package com.example.lembrete_eduardofernandes

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
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

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        if (!token.isNullOrEmpty()) {
//            auth.currentUser?.getIdToken(true)?.addOnCompleteListener { tokenTaks ->
//                val idToken = tokenTaks.result?.token
                navController.navigate(R.id.action_login_to_lembrete)
//                if (token == idToken) {
//
//                }
//            }

        }

    }

}