package com.luisgabriel.riseupichordsproject

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ViewSwitcher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.luisgabriel.riseupichordsproject.databinding.FragmentDesafiosBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DesafiosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DesafiosFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentDesafiosBinding
    lateinit var viewSwitcher: ViewSwitcher
    private var state1: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            viewSwitcher = binding.viewSwitcherMain
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDesafiosBinding.inflate(layoutInflater)
        viewSwitcher = binding.viewSwitcherMain
        binding.buttonDesafios.setOnClickListener(this)
        binding.buttonConquistas.setOnClickListener(this)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DesafiosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DesafiosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_desafios && state1 == false) {
            binding.buttonDesafios.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.light_blue))
            binding.buttonConquistas.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray_blue))
            state1 = true
            viewSwitcher.showNext()
        } else if (v.id == R.id.button_conquistas && state1 == true) {
            binding.buttonConquistas.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.light_blue))
            binding.buttonDesafios.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray_blue))
            state1 = false
            viewSwitcher.showNext()
        }
    }
}