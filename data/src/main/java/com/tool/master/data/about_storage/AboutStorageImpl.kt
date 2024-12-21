package com.tool.master.data.about_storage

import com.orhanobut.hawk.Hawk

class AboutStorageImpl : AboutStorage {

    companion object {
        private const val SHOULD_SHOW_ABOUT_SCREEN_FIRST_KEY = "should_show_about_screen"
    }

    override fun shouldShowAboutScreen(): Boolean {
        return Hawk.get(SHOULD_SHOW_ABOUT_SCREEN_FIRST_KEY, true)
    }

    override fun stopShowingAboutScreen(): Boolean {
        try {
            Hawk.put(SHOULD_SHOW_ABOUT_SCREEN_FIRST_KEY, false)
            return true
        } catch (ex: Exception) {
            return false
        }
    }
}