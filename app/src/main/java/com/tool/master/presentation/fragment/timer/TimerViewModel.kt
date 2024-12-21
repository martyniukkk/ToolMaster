package com.tool.master.presentation.fragment.timer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tool.master.domain.usecase.timer.StartTimerUseCase
import com.tool.master.domain.usecase.timer.StopTimerUseCase

class TimerViewModel(private val startTimerUseCase: com.tool.master.domain.usecase.timer.StartTimerUseCase, private val stopTimerUseCase: com.tool.master.domain.usecase.timer.StopTimerUseCase) :
    ViewModel() {

    private val _timeLeft = MutableLiveData<Long>()
    val timeLeft: LiveData<Long> = _timeLeft

    private val _isFinished = MutableLiveData<Boolean>()
    val isFinished: LiveData<Boolean> = _isFinished

    fun resetTimeLeft() {
        _timeLeft.value = 0L
    }

    fun startTimer(millisInFuture: Long, interval: Long) {
        _isFinished.value = false
        startTimerUseCase.execute(
            millisInFuture,
            interval,
            { millisUntilFinished ->
                _timeLeft.value = millisUntilFinished
            },
            {
                _isFinished.value = true
            }
        )
    }

    fun stopTimer() {
        stopTimerUseCase.execute()
        _isFinished.value = true
    }

    private val _progressMaxLive = MutableLiveData<Float>()
    val progressMaxLive: LiveData<Float> = _progressMaxLive

    fun saveProgressMax(max: Float) {
        _progressMaxLive.value = max
    }

    private val _editTextValueLive = MutableLiveData<String>()
    val editTextValueLive: LiveData<String> = _editTextValueLive

    fun setEditTextValue(value: String) {
        _editTextValueLive.value = value
    }

    override fun onCleared() {
        super.onCleared()
        stopTimer()
    }
}