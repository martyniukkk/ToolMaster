package com.tool.master.di

import com.tool.master.presentation.activity.about.AboutViewModel
import com.tool.master.presentation.activity.fragments.FragmentsViewModel
import com.tool.master.presentation.activity.main.MainViewModel
import com.tool.master.presentation.fragment.flashlight.FlashlightViewModel
import com.tool.master.presentation.fragment.timer.TimerViewModel
import com.tool.master.presentation.fragment.todo.TodoViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<AboutViewModel> {
        AboutViewModel(stopShowingAboutScreenUseCase = get())
    }
    viewModel<MainViewModel> {
        MainViewModel(shouldShowAboutScreenUseCase = get())
    }
    viewModel<TodoViewModel> {
        TodoViewModel(
            getTodoListUseCase = get(),
            removeTodoUseCase = get(),
            saveTodoUseCase = get(),
            updateTodoUseCase = get()
        )
    }
    viewModel<TimerViewModel> {
        TimerViewModel(startTimerUseCase = get(), stopTimerUseCase = get())
    }
    viewModel<FragmentsViewModel> {
        FragmentsViewModel()
    }
    viewModel<FlashlightViewModel> {
        FlashlightViewModel(enableFlashlightUseCase = get(), disableFlashlightUseCase = get())
    }
}