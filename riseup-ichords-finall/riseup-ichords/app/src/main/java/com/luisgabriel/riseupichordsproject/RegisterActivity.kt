package com.luisgabriel.riseupichordsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.luisgabriel.riseupichordsproject.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {

    lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
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
            val emailEmpty = editEmail.text.isEmpty()
            val senhaEmpty = editSenha.text.isEmpty()
            val usuarioEmpty = editUsuario.text.isEmpty()

            imageEmail.visibility = if (!emailEmpty) View.GONE else View.VISIBLE
            textEmail.visibility = imageEmail.visibility

            iconCadeado.visibility = if (!senhaEmpty) View.GONE else View.VISIBLE
            textSenha.visibility = iconCadeado.visibility

            iconPessoa.visibility = if (!usuarioEmpty) View.GONE else View.VISIBLE
            textUsuario.visibility = iconPessoa.visibility
        }
    }


    //Ação do botão
    override fun onClick(v: View) {
        if (v.id == R.id.button_criar) {
            if (binding.editEmail.text.toString() == "" || binding.editSenha.text.toString() == "" || binding.editUsuario.text.toString() == "") {
                Toast.makeText(this,"Preencha todos os campos por favor!", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this,TratamentoUmActivity::class.java))
                finish()
            }
        } else if (v.id == R.id.text_entrar) {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }


    //Atribuição de Botão e EditText's
    fun atribuirEventos() {
        binding.editEmail.addTextChangedListener(this)
        binding.editUsuario.addTextChangedListener(this)
        binding.editSenha.addTextChangedListener(this)
        binding.buttonCriar.setOnClickListener(this)
        binding.textEntrar.setOnClickListener(this)

    }
}