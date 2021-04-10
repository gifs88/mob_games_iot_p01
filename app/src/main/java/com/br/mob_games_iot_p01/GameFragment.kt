package com.br.mob_games_iot_p01

import android.database.DatabaseUtils
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.br.mob_games_iot_p01.databinding.FragmentGameBinding
import com.br.mob_games_iot_p01.helper.ASGame
import com.br.mob_games_iot_p01.helper.ASTimer
import com.br.mob_games_iot_p01.helper.ASTimerCallback
import com.br.mob_games_iot_p01.helper.Constants

class GameFragment : Fragment(), ASTimerCallback {

    private val args: GameFragmentArgs by navArgs()
    private val timerFactory = ASTimer()
    private lateinit var timer: CountDownTimer
    private lateinit var playerTimer: CountDownTimer
    private val game = ASGame()
    private val PLAYER_TIMER_TAG = "PLAYER"
    private val GAME_TIMER_TAG = "GAME"

    private lateinit var bindings: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindings.playerName = args.playerName
        bindings.playerScoreValue = 0
        bindings.cpuScoreValue = 0

        bindings.pedra.setOnClickListener {
            playerAction(Constants.pedra)
        }
        bindings.papel.setOnClickListener {
            playerAction(Constants.papel)
        }
        bindings.tesoura.setOnClickListener {
            playerAction(Constants.tesoura)
        }

        timerFactory.setTimerCallback(this)
        timer = timerFactory.initTimer(90000, GAME_TIMER_TAG)
        playerTimer = timerFactory.initTimer(0, PLAYER_TIMER_TAG)
    }

    private fun playerAction(choice: String) {
        val play_result = game.play(choice)
        playerTimer.cancel()

        bindings.pedra.isEnabled = false
        bindings.papel.isEnabled = false
        bindings.tesoura.isEnabled = false

        bindings.playerChooseText = "${args.playerName}: ${play_result.player_choose.toUpperCase()}" +
                "\nCPU: ${play_result.cpu_choose.toUpperCase()}" +
                "\nVencendor: ${play_result.winner?.toUpperCase() ?: "EMPATE"}"
        bindings.cpuScoreValue = play_result.cpu_score
        bindings.playerScoreValue = play_result.player_score
        bindings.playerChoose.visibility = View.VISIBLE
        bindings.animationView.visibility = View.GONE

        Handler(Looper.getMainLooper()).postDelayed({
            bindings.pedra.isEnabled = true
            bindings.papel.isEnabled = true
            bindings.tesoura.isEnabled = true
            playerTimer = timerFactory.initTimer(5000, PLAYER_TIMER_TAG)
        }, 1000)
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