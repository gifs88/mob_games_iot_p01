package com.br.mob_games_iot_p01

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.br.mob_games_iot_p01.databinding.FragmentGameBinding
import com.br.mob_games_iot_p01.helper.ASTimer
import com.br.mob_games_iot_p01.helper.ASTimerCallback

class GameFragment : Fragment(), ASTimerCallback {

//    TODO 03: Implementar regra de negócio para mostrar animação

    val args: GameFragmentArgs by navArgs()
    var timer = ASTimer()

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
        bindings.playerScore.text = args.playerName
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

        timer.setTimerCallback(this)
        timer.initTimer(90000)
    }

    override fun onTimerStop() {
        findNavController().popBackStack()
    }

    override fun onChange(value: Long) {
        bindings.timer.text = value.toString()
    }

}