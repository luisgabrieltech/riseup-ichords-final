package com.luisgabriel.riseupichordsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.luisgabriel.riseupichordsproject.databinding.ActivityTratamentoDoisBinding

class TratamentoDoisActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityTratamentoDoisBinding


    //Variável Que Observa Se Ao Menos Um Já Foi Selecionado
    private var podePassar = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTratamentoDoisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        atribuirClick()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.view_comecando_) {
            podePassar = true
            binding.imageCheckComecando.visibility = View.VISIBLE
            binding.imageCheckIniciante.visibility = View.GONE
            binding.imageCheckIntermediario.visibility = View.GONE
            binding.imageCheckAvancado.visibility = View.GONE
        } else if (v.id == R.id.view_iniciante_) {
            podePassar = true
            binding.imageCheckIniciante.visibility = View.VISIBLE
            binding.imageCheckComecando.visibility = View.GONE
            binding.imageCheckIntermediario.visibility = View.GONE
            binding.imageCheckAvancado.visibility = View.GONE
        } else if (v.id == R.id.view_intermediario_) {
            podePassar = true
            binding.imageCheckIntermediario.visibility = View.VISIBLE
            binding.imageCheckComecando.visibility = View.GONE
            binding.imageCheckIniciante.visibility = View.GONE
            binding.imageCheckAvancado.visibility = View.GONE
        } else if (v.id == R.id.view_avancado_) {
            podePassar = true
            binding.imageCheckAvancado.visibility = View.VISIBLE
            binding.imageCheckComecando.visibility = View.GONE
            binding.imageCheckIntermediario.visibility = View.GONE
            binding.imageCheckIniciante.visibility = View.GONE
        } else {
            if (podePassar == false) {
                Toast.makeText(this,"Informe o seu nível por favor!",Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this,GeramentoTrilhaActivity::class.java))
                finish()
            }
        }
    }

    //Faz a atribuição de click às views e ao botão
    fun atribuirClick() {
        binding.viewComecando.setOnClickListener(this)
        binding.viewIniciante.setOnClickListener(this)
        binding.viewIntermediario.setOnClickListener(this)
        binding.viewAvancado.setOnClickListener(this)
        binding.buttonAvancar.setOnClickListener(this)
    }
}

