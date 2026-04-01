package com.example.suciapps.pertemuan_3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.suciapps.R
import com.example.suciapps.databinding.ActivityThirdBinding


class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding //bsk wajib pakai ini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inisialisasi komponen
        //val inputNoTujuan: EditText = findViewById(R.id.inputNoTujuan)
        //val btnkirim: Button = findViewById(R.id.btnkirim)

        binding.btnkirim.setOnClickListener {  //ini jgk
            //Mengambil value dari inputNama dan menampilkan di Logcat
            val noTujuan = binding.inputNoTujuan

            Toast.makeText(this, "pesan berhasil dikirim ke: $noTujuan", Toast.LENGTH_SHORT).show()
        }
    }
}