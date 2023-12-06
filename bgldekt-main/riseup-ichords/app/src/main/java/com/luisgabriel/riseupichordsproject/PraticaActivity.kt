package com.luisgabriel.riseupichordsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PraticaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pratica)

        val btnVoltarPratica: ImageView = findViewById(R.id.voltar)

        btnVoltarPratica.setOnClickListener {
            val intent = Intent(this@PraticaActivity, ProximosPassosActivity::class.java)
            startActivity(intent)
        }
    }
}