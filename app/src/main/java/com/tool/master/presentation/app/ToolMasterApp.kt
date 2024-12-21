package com.tool.master.presentation.app

import android.app.Application
import com.tool.master.di.appModule
import com.tool.master.di.dataModule
import com.tool.master.di.domainModule
import com.orhanobut.hawk.Hawk
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ToolMasterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        startKoin {
            androidContext(this@ToolMasterApp)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}