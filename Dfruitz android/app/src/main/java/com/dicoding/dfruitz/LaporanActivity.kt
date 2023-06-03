package com.dicoding.dfruitz

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class LaporanActivity : AppCompatActivity() {

    private lateinit var spinnerJenisTindakan: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        spinnerJenisTindakan = findViewById(R.id.spinnerJenisTindakan)

        val jenisTindakanOptions = resources.getStringArray(R.array.jenis_tindakan_options)
        val jenisTindakanAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisTindakanOptions)
        jenisTindakanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerJenisTindakan.adapter = jenisTindakanAdapter





    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
