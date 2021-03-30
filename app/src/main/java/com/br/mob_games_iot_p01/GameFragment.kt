package com.br.mob_games_iot_p01

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.br.mob_games_iot_p01.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var bindings: FragmentGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindings.playerChooseText = getString(R.string.player_choose_placeholder)

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