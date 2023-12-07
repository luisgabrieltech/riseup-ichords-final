package com.luisgabriel.riseupichordsproject

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ProximosPassosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximos_passos)

        val btnVoltarProxPassos: ImageView = findViewById(R.id.image_voltar)

        btnVoltarProxPassos.setOnClickListener {
            val intent = Intent(this@ProximosPassosActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val btnEntrarPratica: ImageView = findViewById(R.id.image_pratica_um)

        btnEntrarPratica.setOnClickListener{
            val intent = Intent(this@ProximosPassosActivity, PraticaActivity::class.java)
            startActivity(intent)
        }

    }
}