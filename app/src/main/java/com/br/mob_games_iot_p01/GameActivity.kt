package com.br.mob_games_iot_p01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GameActivity : AppCompatActivity() {

    private lateinit var btnPedra: Button
    private lateinit var btnPapel: Button
    private lateinit var btnTesoura: Button
    private lateinit var tvPlayerChoose: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO 03: Trocar setContentView por DataBindingUtil
        setContentView(R.layout.activity_game)

        setupViews()
    }

    private fun setupViews() {
        btnPedra = findViewById(R.id.pedra)
        btnPapel = findViewById(R.id.papel)
        btnTesoura = findViewById(R.id.tesoura)
        tvPlayerChoose = findViewById(R.id.player_choose)
        setupListeners()
    }

    //TODO 04: Criar variável correspondente ao estado do click do usuário
    //TODO 05: Atualizar variável de acorodo com o click do usuário
    private fun setupListeners() {
        btnPedra.setOnClickListener {
            tvPlayerChoose.text = btnPedra.text
        }
        btnPapel.setOnClickListener {
            tvPlayerChoose.text = btnPapel.text
        }
        btnTesoura.setOnClickListener {
            tvPlayerChoose.text = btnTesoura.text
        }
    }
}