package com.tool.master.domain.repository

interface AboutRepository {

    fun shouldShowAboutScreen(): Boolean

    fun stopShowingAboutScreen(): Boolean
}