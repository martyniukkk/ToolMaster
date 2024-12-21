package com.tool.master.domain.usecase.about

import com.tool.master.domain.repository.AboutRepository

class StopShowingAboutScreenUseCase(private val aboutRepository: AboutRepository) {

    fun execute(): Boolean {
        return aboutRepository.stopShowingAboutScreen()
    }
}