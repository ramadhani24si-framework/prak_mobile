package com.example.suciapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.suciapps.Home.pertemuan_2.SecondActivity
import com.example.suciapps.Home.pertemuan_3.ThirdActivity
import com.example.suciapps.Home.pertemuan_4.FourthActivity
import com.example.suciapps.Home.pertemuan_5.FifthActivity
import com.example.suciapps.Home.pertemuan_7.SeventhActivity
import com.example.suciapps.R
import com.example.suciapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    Log.e("Logout", "User logout")
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
        binding.btnToSecond.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnTothird.setOnClickListener {
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}
