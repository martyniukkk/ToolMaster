package com.tool.master.domain.usecase.timer

import com.tool.master.domain.repository.TimerRepository

class StopTimerUseCase(private val timerRepository: TimerRepository) {

    fun execute(): Boolean {
        return timerRepository.stopTimer()
    }
}