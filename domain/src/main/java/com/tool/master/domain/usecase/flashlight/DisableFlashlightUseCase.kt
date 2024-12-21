package com.tool.master.domain.usecase.flashlight

import com.tool.master.domain.repository.FlashlightRepository

class DisableFlashlightUseCase(private val flashlightRepository: FlashlightRepository) {

    fun execute(): Boolean {
        return flashlightRepository.disableFlashlight()
    }
}