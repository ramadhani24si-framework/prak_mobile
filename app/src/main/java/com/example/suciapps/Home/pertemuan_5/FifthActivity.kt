package com.example.suciapps.Home.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.suciapps.R
import com.example.suciapps.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            // IMPROVISASI 1: Matikan judul teks bawaan agar logo ke tengah
            setDisplayShowTitleEnabled(false)

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            // IMPROVISASI 3: Logika Ganti Tema
            R.id.action_dark_mode -> {
                val currentMode = AppCompatDelegate.getDefaultNightMode()
                if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    Toast.makeText(this, "Mode Terang Aktif", Toast.LENGTH_SHORT).show()
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    Toast.makeText(this, "Mode Gelap Aktif", Toast.LENGTH_SHORT).show()
                }
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}