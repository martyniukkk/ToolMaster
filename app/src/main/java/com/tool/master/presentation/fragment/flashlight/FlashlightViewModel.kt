package com.tool.master.presentation.fragment.flashlight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tool.master.domain.usecase.flashlight.DisableFlashlightUseCase
import com.tool.master.domain.usecase.flashlight.EnableFlashlightUseCase

class FlashlightViewModel(
    private val enableFlashlightUseCase: com.tool.master.domain.usecase.flashlight.EnableFlashlightUseCase,
    private val disableFlashlightUseCase: com.tool.master.domain.usecase.flashlight.DisableFlashlightUseCase
) : ViewModel() {

    private val _flashlightEnabledStateLive = MutableLiveData<Boolean>()
    val flashlightEnabledStateLive: LiveData<Boolean> = _flashlightEnabledStateLive

    fun enableFlashlight() {
        enableFlashlightUseCase.execute()
        _flashlightEnabledStateLive.value = true
    }

    fun disableFlashlight() {
        disableFlashlightUseCase.execute()
        _flashlightEnabledStateLive.value = false
    }

    init {
        _flashlightEnabledStateLive.value = false
    }
}