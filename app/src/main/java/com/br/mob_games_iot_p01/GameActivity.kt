package com.br.mob_games_iot_p01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.br.mob_games_iot_p01.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this, R.layout.activity_game)
        bindings.playerChooseText = getString(R.string.player_choose_placeholder)
        setupListeners()
    }

    private fun setupListeners() {
        bindings.pedra.setOnClickListener {
            bindings.playerChooseText = getString(R.string.pedra)
        }
        bindings.papel.setOnClickListener {
            bindings.playerChooseText = getString(R.string.papel)
        }
        bindings.tesoura.setOnClickListener {
            bindings.playerChooseText = getString(R.string.tesoura)
        }
    }
}