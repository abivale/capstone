package com.dicoding.dfruitz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SignUp : AppCompatActivity() {
    private lateinit var login: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        login = findViewById(R.id.login)
        login.setOnClickListener {
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}