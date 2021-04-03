package com.br.mob_games_iot_p01.ranking_recycleView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.mob_games_iot_p01.R

class RankingViewHolder (val row: View) : RecyclerView.ViewHolder(row) {
    val position: TextView = row.findViewById(R.id.position)
    val player: TextView = row.findViewById(R.id.player)
    val score: TextView = row.findViewById(R.id.score)
}