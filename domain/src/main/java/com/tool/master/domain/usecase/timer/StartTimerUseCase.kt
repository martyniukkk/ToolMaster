package com.tool.master.domain.usecase.timer

import com.tool.master.domain.repository.TimerRepository

class StartTimerUseCase(private val timerRepository: TimerRepository) {

    fun execute(
        millisInFuture: Long,
        interval: Long,
        onTick: (Long) -> Unit,
        onFinish: () -> Unit
    ): Boolean {
        return timerRepository.startTimer(
            millisInFuture = millisInFuture,
            interval = interval,
            onTick = onTick,
            onFinish = onFinish
        )
    }
}