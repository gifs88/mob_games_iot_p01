package com.br.mob_games_iot_p01.helper

import com.br.mob_games_iot_p01.data.PlayItem

class ASGame {
    private var score = 0
    private var player_score = 0
    private var cpu_score = 0
    private val values = listOf(Constants.pedra, Constants.papel, Constants.tesoura)

    private fun cpuPlay() : String = values.random()

    private fun calcWinner(player_choice: String, cpu_choice: String) : String? {
        var winner: String? = null
        when(player_choice) {
            Constants.pedra -> {
                when (cpu_choice) {
                    Constants.papel -> { winner = Constants.cpu }
                    Constants.tesoura -> { winner = Constants.player }
                }
            }
            Constants.papel -> {
                when (cpu_choice) {
                    Constants.pedra -> { winner = Constants.player }
                    Constants.tesoura -> { winner = Constants.cpu }
                }
            }
            Constants.tesoura -> {
                when (cpu_choice) {
                    Constants.papel -> { winner = Constants.player }
                    Constants.pedra -> { winner = Constants.cpu }
                }
            }
        }
        return winner
    }

    fun play(player_choice: String) : PlayItem {
        val cpu_choice = cpuPlay()
        val winner = calcWinner(player_choice, cpu_choice)

        winner?.let {
            when (it) {
                Constants.player -> {
                    player_score = player_score.plus(1)
                    score = score.plus(10)
                }
                Constants.cpu -> {
                    cpu_score = cpu_score.plus(1)
                    score = score.minus(10)
                }
            }
        }

        return PlayItem(player_choice, cpu_choice, player_score, cpu_score, winner, score)
    }
}