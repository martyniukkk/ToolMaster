package com.tool.master.di

import org.koin.dsl.module

val domainModule = module {

    factory<com.tool.master.domain.usecase.about.ShouldShowAboutScreenUseCase> {
        com.tool.master.domain.usecase.about.ShouldShowAboutScreenUseCase(aboutRepository = get())
    }
    factory<com.tool.master.domain.usecase.about.StopShowingAboutScreenUseCase> {
        com.tool.master.domain.usecase.about.StopShowingAboutScreenUseCase(aboutRepository = get())
    }

    factory<com.tool.master.domain.usecase.flashlight.DisableFlashlightUseCase> {
        com.tool.master.domain.usecase.flashlight.DisableFlashlightUseCase(flashlightRepository = get())
    }
    factory<com.tool.master.domain.usecase.flashlight.EnableFlashlightUseCase> {
        com.tool.master.domain.usecase.flashlight.EnableFlashlightUseCase(flashlightRepository = get())
    }

    factory<com.tool.master.domain.usecase.timer.StartTimerUseCase> {
        com.tool.master.domain.usecase.timer.StartTimerUseCase(timerRepository = get())
    }
    factory<com.tool.master.domain.usecase.timer.StopTimerUseCase> {
        com.tool.master.domain.usecase.timer.StopTimerUseCase(timerRepository = get())
    }

    factory<com.tool.master.domain.usecase.todo.GetTodoListUseCase> {
        com.tool.master.domain.usecase.todo.GetTodoListUseCase(todoRepository = get())
    }
    factory<com.tool.master.domain.usecase.todo.RemoveTodoUseCase> {
        com.tool.master.domain.usecase.todo.RemoveTodoUseCase(todoRepository = get())
    }
    factory<com.tool.master.domain.usecase.todo.SaveTodoUseCase> {
        com.tool.master.domain.usecase.todo.SaveTodoUseCase(todoRepository = get())
    }
    factory<com.tool.master.domain.usecase.todo.UpdateTodoUseCase> {
        com.tool.master.domain.usecase.todo.UpdateTodoUseCase(todoRepository = get())
    }
}