package com.tool.master.presentation.activity.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel(
    private val stopShowingAboutScreenUseCase: com.tool.master.domain.usecase.about.StopShowingAboutScreenUseCase,
) : ViewModel() {

    private val _finishAboutScreenResult = MutableLiveData<Boolean>()
    val finishAboutScreenResult: LiveData<Boolean> = _finishAboutScreenResult

    fun stopShowingAboutScreen() {
        _finishAboutScreenResult.value = stopShowingAboutScreenUseCase.execute()
    }
}