package com.dicoding.dfruitz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Welcome : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        emailEditText = findViewById(R.id.editText)
        passwordEditText = findViewById(R.id.editText2)
        loginButton = findViewById(R.id.goIn)
        signup = findViewById(R.id.signup)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidCredentials(email, password)) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish() // Finish the current activity to prevent going back to the login screen
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        signup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        // Sementara
        val adminEmail = "admin"
        val adminPassword = "admin"

        return email == adminEmail && password == adminPassword
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
