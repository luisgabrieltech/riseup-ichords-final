package com.luisgabriel.riseupichordsproject

import Adapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luisgabriel.riseupichordsproject.databinding.FragmentMusicasBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicasFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentMusicasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMusicasBinding.inflate(layoutInflater)
        binding.viewCharlie.setOnClickListener(this)
        val dataList = listOf(
            MyData(name = "10 musicas", quantidade = "Pop Nacional"),
            MyData(name = "20 musicas", quantidade = "Forró"),
            MyData(name = "8 musicas", quantidade = "Rock Brasileiro"),
            MyData(name = "15 musicas", quantidade = "Pagode"),
            MyData(name = "11 musicas", quantidade = "Sertanejo"))
        val recyclerView: RecyclerView = binding.recyclerViewMusicas

        val adapter = Adapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = layoutManager

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MusicasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MusicasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View) {
        if(v.id == R.id.view_charlie) {
            startActivity(Intent(requireContext(),MusicsActivity::class.java))
        }
    }
}