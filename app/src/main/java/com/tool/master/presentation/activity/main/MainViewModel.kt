package com.tool.master.presentation.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tool.master.domain.usecase.about.ShouldShowAboutScreenUseCase

class MainViewModel(private val shouldShowAboutScreenUseCase: com.tool.master.domain.usecase.about.ShouldShowAboutScreenUseCase) : ViewModel() {

    private val _shouldShowAboutScreenLive = MutableLiveData<Boolean>()
    val shouldShowAboutScreenLive: LiveData<Boolean> = _shouldShowAboutScreenLive

    fun getShouldShowAboutScreen() {
        _shouldShowAboutScreenLive.value = shouldShowAboutScreenUseCase.execute()
    }
}