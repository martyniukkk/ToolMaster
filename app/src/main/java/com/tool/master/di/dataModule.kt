package com.tool.master.di

import org.koin.dsl.module

val dataModule = module {

    single<com.tool.master.data.about_storage.AboutStorage> {
        com.tool.master.data.about_storage.AboutStorageImpl()
    }
    single<com.tool.master.domain.repository.AboutRepository> {
        com.tool.master.data.repository.AboutRepositoryImpl(aboutStorage = get())
    }

    single<com.tool.master.data.flashlight_manager.FlashlightManager> {
        com.tool.master.data.flashlight_manager.FlashlightManagerImpl(context = get())
    }
    single<com.tool.master.domain.repository.FlashlightRepository> {
        com.tool.master.data.repository.FlashlightRepositoryImpl(flashlightManager = get())
    }

    single<com.tool.master.data.timer_manager.TimerManager> {
        com.tool.master.data.timer_manager.TimerManagerImpl()
    }
    single<com.tool.master.domain.repository.TimerRepository> {
        com.tool.master.data.repository.TimerRepositoryImpl(timerManager = get())
    }

    single<com.tool.master.data.todo_storage.TodoStorage> {
        com.tool.master.data.todo_storage.TodoStorageImpl(context = get())
    }
    single<com.tool.master.domain.repository.TodoRepository> {
        com.tool.master.data.repository.TodoRepositoryImpl(todoStorage = get())
    }
}