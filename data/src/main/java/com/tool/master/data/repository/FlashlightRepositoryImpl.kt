package com.tool.master.data.repository

import com.tool.master.data.flashlight_manager.FlashlightManager
import com.tool.master.domain.repository.FlashlightRepository

class FlashlightRepositoryImpl(private val flashlightManager: FlashlightManager) : FlashlightRepository {

    override fun enableFlashlight(): Boolean {
        return flashlightManager.enable()
    }

    override fun disableFlashlight(): Boolean {
        return flashlightManager.disable()
    }
}