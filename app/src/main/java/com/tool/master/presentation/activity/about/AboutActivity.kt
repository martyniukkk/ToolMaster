package com.tool.master.presentation.activity.about

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tool.master.databinding.ActivityAboutBinding
import com.tool.master.presentation.activity.fragments.FragmentsActivity
import com.tool.master.presentation.activity.name.NameActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    private val viewModel by viewModel<AboutViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.finishAboutScreenResult.observe(this) { finishAboutScreen ->
            if (finishAboutScreen) {
                startActivity(Intent(this@AboutActivity, FragmentsActivity::class.java))
                finish()
            }
        }
        binding.start.setOnClickListener {
            startActivity(Intent(this@AboutActivity, NameActivity::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.finishAboutScreenResult.removeObservers(this)
    }
}