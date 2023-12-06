package com.luisgabriel.riseupichordsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.luisgabriel.riseupichordsproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {

    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        atribuirEventos()
    }

    //Eventos dos EditText's
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
    override fun afterTextChanged(s: Editable?) {
        with(binding) {
            iconPessoa.visibility = if (editEmail.text.toString().isNotEmpty()) View.GONE else View.VISIBLE
            textEmail.visibility = iconPessoa.visibility

            iconCadeado.visibility = if (editSenha.text.toString().isNotEmpty()) View.GONE else View.VISIBLE
            textSenha.visibility = iconCadeado.visibility
        }
    }


    //Ação dos botões
    override fun onClick(v: View) {
        if (v.id == R.id.button_entrar) {
            if (binding.editEmail.text.toString() == "" || binding.editSenha.text.toString() == "") {
                Toast.makeText(this,"Preencha todos os campos por favor!", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        } else if (v.id == R.id.text_criar_agora) {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }
    }

    //Atribuição de Botão e EditText's
    fun atribuirEventos() {
        binding.editEmail.addTextChangedListener(this)
        binding.editSenha.addTextChangedListener(this)
        binding.buttonEntrar.setOnClickListener(this)
        binding.textCriarAgora.setOnClickListener(this)

    }
}