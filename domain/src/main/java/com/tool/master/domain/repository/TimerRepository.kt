package com.tool.master.domain.repository

interface TimerRepository {

    fun startTimer(
        millisInFuture: Long,
        interval: Long,
        onTick: (Long) -> Unit,
        onFinish: () -> Unit
    ): Boolean

    fun stopTimer(): Boolean
}