package com.br.mob_games_iot_p01

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.mob_games_iot_p01.data.ASSharedPreferences
import com.br.mob_games_iot_p01.data.RankingItem
import com.br.mob_games_iot_p01.ranking_recycleView.RankingAdapter

class RankingFragment : Fragment() {

    private lateinit var sharedPrefs: ASSharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPrefs = ASSharedPreferences(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ranking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv: RecyclerView = view.findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = RankingAdapter(sharedPrefs.getRanking())
    }

}