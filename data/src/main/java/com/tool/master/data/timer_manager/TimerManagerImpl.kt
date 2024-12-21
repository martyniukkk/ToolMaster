package com.tool.master.data.timer_manager

import android.os.CountDownTimer

class TimerManagerImpl : TimerManager {

    private var countDownTimer: CountDownTimer? = null

    override fun start(
        millisInFuture: Long,
        interval: Long,
        onTick: (Long) -> Unit,
        onFinish: () -> Unit
    ): Boolean {
        try {
            countDownTimer = object : CountDownTimer(millisInFuture, interval) {
                override fun onTick(millisUntilFinished: Long) {
                    onTick(millisUntilFinished)
                }

                override fun onFinish() {
                    onFinish()
                }
            }.start()
            return true
        } catch (ex: Exception) {
            return false
        }
    }

    override fun stop(): Boolean {
        countDownTimer?.cancel()
        return countDownTimer != null
    }
}