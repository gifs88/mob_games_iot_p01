package com.br.mob_games_iot_p01

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.br.mob_games_iot_p01.data.ASSharedPreferences
import com.br.mob_games_iot_p01.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var sharedPrefs: ASSharedPreferences
    private lateinit var bindings: FragmentStartBinding
    private lateinit var player: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPrefs = ASSharedPreferences(context)
        player = sharedPrefs.getPlayer().toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindings.inputPlayer.setText(player)

        super.onViewCreated(view, savedInstanceState)
        bindings.next.setOnClickListener {
            val playerName = bindings.inputPlayer.text.toString()
            savePlayerName(playerName)
            val action = StartFragmentDirections.actionStartFragmentToGameFragment(playerName)
            view.findNavController().navigate(action)
        }

        bindings.ranking.setOnClickListener {
            view.findNavController().navigate(R.id.action_startFragment_to_rankingFragment)
        }
    }

    private fun savePlayerName(name: String) {
        if (name != player) {
            sharedPrefs.savePlayer(name)
        }
    }

}