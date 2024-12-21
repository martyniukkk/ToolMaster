package com.tool.master.di

import com.tool.master.data.about_storage.AboutStorage
import com.tool.master.data.about_storage.AboutStorageImpl
import com.tool.master.data.flashlight_manager.FlashlightManager
import com.tool.master.data.flashlight_manager.FlashlightManagerImpl
import com.tool.master.data.repository.AboutRepositoryImpl
import com.tool.master.data.repository.FlashlightRepositoryImpl
import com.tool.master.data.repository.TimerRepositoryImpl
import com.tool.master.data.repository.TodoRepositoryImpl
import com.tool.master.data.timer_manager.TimerManager
import com.tool.master.data.timer_manager.TimerManagerImpl
import com.tool.master.data.todo_storage.TodoStorage
import com.tool.master.data.todo_storage.TodoStorageImpl
import com.tool.master.domain.repository.AboutRepository
import com.tool.master.domain.repository.FlashlightRepository
import com.tool.master.domain.repository.TimerRepository
import com.tool.master.domain.repository.TodoRepository
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