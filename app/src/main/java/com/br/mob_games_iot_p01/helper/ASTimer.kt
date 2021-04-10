package com.br.mob_games_iot_p01.helper

import android.os.CountDownTimer

class ASTimer {

    private var callback: ASTimerCallback? = null

    fun setTimerCallback(callback: ASTimerCallback) {
        this.callback = callback
    }

    fun initTimer(time: Long, name: String) {
        val timer = object: CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                callback?.onChange(name, millisUntilFinished/1000)
            }

            override fun onFinish() {
                this.cancel()
                callback?.onTimerStop(name)
            }

            fun cancelTimer() {
                this.cancel()
            }
        }
        timer.start()
    }
}

interface ASTimerCallback {
    fun onTimerStop(name: String)
    fun onChange(name: String, value: Long)
}

