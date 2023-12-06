package com.luisgabriel.riseupichordsproject

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ViewSwitcher
import androidx.core.content.ContextCompat
import com.luisgabriel.riseupichordsproject.R
import com.luisgabriel.riseupichordsproject.databinding.ActivityMusicsBinding

class MusicsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMusicsBinding
    private var state1: Boolean = true
    lateinit var viewSwitcher: ViewSwitcher


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSolo.setOnClickListener(this)
        binding.buttonRanked.setOnClickListener(this)
        binding.imageVoltar.setOnClickListener(this)
        viewSwitcher = findViewById(R.id.switch_unico)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_solo && state1 == false) {
            binding.buttonSolo.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.light_blue))
            binding.buttonRanked.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray_blue))
            state1 = true
            viewSwitcher.showNext()
        } else if(v.id == R.id.button_ranked && state1 == true) {
            binding.buttonRanked.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.light_blue))
            binding.buttonSolo.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray_blue))
            state1 = false
            viewSwitcher.showNext()
        } else if (v.id == R.id.image_voltar) {
            finish()
        }
    }
}