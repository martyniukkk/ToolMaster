package com.tool.master.domain.repository

interface FlashlightRepository {

    fun enableFlashlight(): Boolean

    fun disableFlashlight(): Boolean
}