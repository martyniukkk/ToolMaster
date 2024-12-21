package com.tool.master.data.repository

import com.tool.master.data.timer_manager.TimerManager
import com.tool.master.domain.repository.TimerRepository

class TimerRepositoryImpl(private val timerManager: TimerManager) : TimerRepository {

    override fun startTimer(
        millisInFuture: Long,
        interval: Long,
        onTick: (Long) -> Unit,
        onFinish: () -> Unit
    ): Boolean {
        return timerManager.start(
            millisInFuture = millisInFuture,
            interval = interval,
            onTick = onTick,
            onFinish = onFinish
        )
    }

    override fun stopTimer(): Boolean {
        return timerManager.stop()
    }
}