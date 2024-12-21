package com.tool.master.presentation.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tool.master.presentation.activity.about.AboutActivity
import com.tool.master.presentation.activity.fragments.FragmentsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.shouldShowAboutScreenLive.observe(this) { shouldShowAbout ->
            if (shouldShowAbout) {
                startActivity(Intent(this, AboutActivity::class.java))
            } else {
                startActivity(Intent(this, FragmentsActivity::class.java))
            }
            finish()
        }

        viewModel.getShouldShowAboutScreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.shouldShowAboutScreenLive.removeObservers(this)
    }
}