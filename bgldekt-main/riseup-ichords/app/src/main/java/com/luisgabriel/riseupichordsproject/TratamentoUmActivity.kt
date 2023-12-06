package com.luisgabriel.riseupichordsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import com.luisgabriel.riseupichordsproject.databinding.ActivityTratamentoUmBinding

class TratamentoUmActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityTratamentoUmBinding


    //Contador De Quanto estilos Foram Escolhidos
    var contadorEstilos = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTratamentoUmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        atribuirClick()
    }


    //Ações dos clicks
    override fun onClick(v: View) {
        when (v.id) {
            R.id.view_mpb -> manipularCheck(binding.imageCheckMpb)
            R.id.view_Jazz -> manipularCheck(binding.imageCheckJazz)
            R.id.view_classica -> manipularCheck(binding.imageCheckClassica)
            R.id.view_Rock -> manipularCheck(binding.imageCheckRock)
            R.id.view_sertanejo -> manipularCheck(binding.imageCheckSertanejo)
            R.id.view_Pop -> manipularCheck(binding.imageCheckPop)
            R.id.button_avancar -> if (contadorEstilos == 0) {
                    Toast.makeText(this,"Escolha um estilo ao menos por favor!",
                        Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this,TratamentoDoisActivity::class.java))
                    finish()
                }
        }
    }



    //Faz a atribuição de click às views e ao botão
    fun atribuirClick() {
        binding.viewMpb.setOnClickListener(this)
        binding.viewJazz.setOnClickListener(this)
        binding.viewClassica.setOnClickListener(this)
        binding.viewRock.setOnClickListener(this)
        binding.viewSertanejo.setOnClickListener(this)
        binding.viewPop.setOnClickListener(this)
        binding.buttonAvancar.setOnClickListener(this)
    }


    //Manipulação do ícone de confirmação
    private fun manipularCheck(imageView: ImageView) {
        if (!imageView.isVisible) {
            imageView.visibility = View.VISIBLE
            contadorEstilos++
        } else {
            imageView.visibility = View.GONE
            contadorEstilos -= 1
        }
    }
}