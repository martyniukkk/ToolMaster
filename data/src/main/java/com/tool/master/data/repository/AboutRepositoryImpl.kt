package com.tool.master.data.repository

import com.tool.master.data.about_storage.AboutStorage
import com.tool.master.domain.repository.AboutRepository

class AboutRepositoryImpl(private val aboutStorage: AboutStorage) : AboutRepository {

    override fun shouldShowAboutScreen(): Boolean {
        return aboutStorage.shouldShowAboutScreen()
    }

    override fun stopShowingAboutScreen(): Boolean {
        return aboutStorage.stopShowingAboutScreen()
    }
}