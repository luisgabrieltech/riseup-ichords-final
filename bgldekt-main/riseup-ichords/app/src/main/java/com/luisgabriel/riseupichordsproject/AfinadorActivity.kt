package com.luisgabriel.riseupichordsproject

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ViewSwitcher
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.luisgabriel.riseupichordsproject.databinding.ActivityAfinadorBinding
import com.luisgabriel.riseupichordsproject.databinding.FragmentDesafiosBinding

class AfinadorActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityAfinadorBinding
    lateinit var viewSwitcher: ViewSwitcher
    private var state1: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfinadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewSwitcher = binding.switcherAfinador
        atribuirClick()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_corda_a_corda && state1 == false) {
            binding.buttonCordaACorda.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.light_blue))
            binding.buttonCromatico.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray))
            state1 = true
            viewSwitcher.showNext()
        } else if (v.id == R.id.button_cromatico && state1 == true) {
            binding.buttonCromatico.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.light_blue))
            binding.buttonCordaACorda.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray))
            state1 = false
            viewSwitcher.showNext()
        } else if (v.id == R.id.image_voltar_afinador) {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }


    fun atribuirClick() {
        binding.buttonCordaACorda.setOnClickListener(this)
        binding.buttonCromatico.setOnClickListener(this)
        binding.imageVoltarAfinador.setOnClickListener(this)
    }
}