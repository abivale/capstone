package com.dicoding.dfruitz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class SignUp : AppCompatActivity() {
    private lateinit var login: TextView
    private lateinit var signUpButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        login = findViewById(R.id.login)
        signUpButton = findViewById(R.id.button)
        nameEditText = findViewById(R.id.nama)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)

        login.setOnClickListener {
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (name.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all input needed", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, email, password)
                sendUserDataToServer(user)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun sendUserDataToServer(user: User) {
        val requestBody = FormBody.Builder()
            .add("name", user.name)
            .add("email", user.email)
            .add("password", user.password)
            .build()

        val request = Request.Builder()
            .url("") //Url taruh sini
            .post(requestBody)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(applicationContext, "Network request failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                if (response.isSuccessful && responseBody != null) {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "Sign-up successful", Toast.LENGTH_SHORT).show()
                        try {
                            val jsonResponse = JSONObject(responseBody)
                            val userId = jsonResponse.getString("id") // Kasi kolom id di database, selebihnya tambahin aja

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "Sign-up failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}
