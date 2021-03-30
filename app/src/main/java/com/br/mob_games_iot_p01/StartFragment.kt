package com.br.mob_games_iot_p01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.br.mob_games_iot_p01.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var bindings: FragmentStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindings.next.setOnClickListener {
            val playerName = bindings.inputPlayer.text.toString()
            val action = StartFragmentDirections.actionStartFragmentToGameFragment(playerName)
            view.findNavController().navigate(action)
        }
    }

}