package com.br.mob_games_iot_p01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class GameActivity : AppCompatActivity() {

    private lateinit var btnPedra: Button
    private lateinit var btnPapel: Button
    private lateinit var btnTesoura: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        setupViews()
    }

    private fun setupViews() {
        btnPedra = findViewById(R.id.pedra)
        btnPapel = findViewById(R.id.papel)
        btnTesoura = findViewById(R.id.tesoura)
        setupListeners()
    }

    //TODO 05: Alterar listener dobotões pare que eles printem o valor do texto do botão no textview da área de jogo
    private fun setupListeners() {
        btnPedra.setOnClickListener {
            Toast.makeText(this, getString(R.string.pedra), Toast.LENGTH_SHORT).show()
        }
        btnPapel.setOnClickListener {
            Toast.makeText(this, getString(R.string.papel), Toast.LENGTH_SHORT).show()
        }
        btnTesoura.setOnClickListener {
            Toast.makeText(this, getString(R.string.tesoura), Toast.LENGTH_SHORT).show()
        }
    }
}