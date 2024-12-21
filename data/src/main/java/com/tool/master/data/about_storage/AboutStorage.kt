package com.tool.master.data.about_storage

interface AboutStorage {

    fun shouldShowAboutScreen(): Boolean

    fun stopShowingAboutScreen(): Boolean
}