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
import com.br.mob_games_iot_p01.helper.ASGame
import com.br.mob_games_iot_p01.helper.ASTimer
import com.br.mob_games_iot_p01.helper.ASTimerCallback
import com.br.mob_games_iot_p01.helper.Constants

class GameFragment : Fragment(), ASTimerCallback {

    private val args: GameFragmentArgs by navArgs()
    private val timer = ASTimer()
    private val playerTimer = ASTimer()
    private val game = ASGame()
    private val PLAYER_TIMER_TAG = "PLAYER"
    private val GAME_TIMER_TAG = "GAME"

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
            playerAction(Constants.pedra)
        }
        bindings.papel.setOnClickListener {
            bindings.playerChooseText = getString(R.string.papel)
            playerAction(Constants.papel)
        }
        bindings.tesoura.setOnClickListener {
            bindings.playerChooseText = getString(R.string.tesoura)
            playerAction(Constants.tesoura)
        }

        timer.setTimerCallback(this)
        timer.initTimer(90000, GAME_TIMER_TAG)
        playerTimer.setTimerCallback(this)
    }

    private fun playerAction(choice: String) {
        bindings.playerChoose.visibility = View.VISIBLE
        bindings.animationView.visibility = View.GONE
        val play_result = game.play(choice)
        //playerTimer.initTimer(5000, PLAYER_TIMER_TAG)
    }

    private fun playerInactive() {
        bindings.animationView.visibility = View.VISIBLE
        bindings.playerChoose.visibility = View.GONE
    }

    override fun onTimerStop(name: String) {
        when(name) {
            GAME_TIMER_TAG -> findNavController().popBackStack()
            PLAYER_TIMER_TAG -> playerInactive()
        }
    }

    override fun onChange(name: String, value: Long) {
        when(name) {
            GAME_TIMER_TAG -> bindings.timer.text = value.toString()
            PLAYER_TIMER_TAG -> {}
        }
    }

}