package com.luisgabriel.riseupichordsproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.luisgabriel.riseupichordsproject.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.HashSet
import java.util.Locale

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val textView = rootView.findViewById<TextView>(R.id.days)

        val sharedPreferences = requireActivity().getSharedPreferences("Prefs", Context.MODE_PRIVATE)

        val ENTRY_DATES = "entry_dates"

        val entryDates = sharedPreferences.getStringSet(ENTRY_DATES, HashSet())

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date())
        entryDates?.add(currentDate)

        val editor = sharedPreferences.edit()
        editor.putStringSet(ENTRY_DATES, entryDates)
        editor.apply()

        textView.text = entryDates?.size.toString()

        binding.card2home.setOnClickListener {
            val intent = Intent(requireContext(), ProximosPassosActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
