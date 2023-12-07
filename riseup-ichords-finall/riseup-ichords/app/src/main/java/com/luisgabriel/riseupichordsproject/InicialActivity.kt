package com.luisgabriel.riseupichordsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        val btnLogin: Button = findViewById(R.id.button1_inicial)
        val btnRegistro: Button = findViewById(R.id.button2_inicial)

        btnRegistro.setOnClickListener {
            val intent = Intent(this@InicialActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this@InicialActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}


