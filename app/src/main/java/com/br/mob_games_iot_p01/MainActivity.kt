package com.br.mob_games_iot_p01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToGameActivity()
    }

    private fun goToGameActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }, 5000)
    }
}