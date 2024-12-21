package com.tool.master.presentation.activity.name

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tool.master.databinding.ActivityNameBinding
import com.tool.master.presentation.activity.about.AboutViewModel
import com.tool.master.presentation.activity.fragments.FragmentsActivity
import com.kongzue.dialogx.dialogs.PopTip
import com.orhanobut.hawk.Hawk
import org.koin.androidx.viewmodel.ext.android.viewModel

class NameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNameBinding
    private val viewModel by viewModel<AboutViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.confirm.setOnClickListener {
            if (binding.ediText.text.toString().isNotEmpty()) {
                Hawk.put("userName", binding.ediText.text.toString())
                startActivity(Intent(this@NameActivity, FragmentsActivity::class.java))
                finish()
                viewModel.stopShowingAboutScreen()
            } else {
                PopTip.show("Please enter your name")
            }
        }
    }
}