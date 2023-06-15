package com.dicoding.dfruitz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.dfruitz.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.login.setOnClickListener{
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            val nama = binding.namaIN.text.toString()
            val email = binding.emailIN.text.toString()
            val pass = binding.passwordIN.text.toString()

            if (nama.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, Welcome::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
