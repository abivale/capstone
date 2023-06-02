package com.dicoding.dfruitz

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val iconButton: ImageButton = findViewById(R.id.iconButton)
        iconButton.setOnClickListener {


            val intent = Intent(this, LaporanActivity::class.java)
            intent.putExtra("isLoggedIn", true)
            startActivity(intent)
        }
    }
}
