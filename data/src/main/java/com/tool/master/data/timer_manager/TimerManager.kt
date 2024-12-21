package com.tool.master.data.timer_manager

interface TimerManager {

    fun start(
        millisInFuture: Long,
        interval: Long,
        onTick: (Long) -> Unit,
        onFinish: () -> Unit
    ): Boolean

    fun stop(): Boolean
}