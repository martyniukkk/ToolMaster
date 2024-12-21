package com.tool.master.presentation.activity.fragments

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.tool.master.R
import com.tool.master.databinding.ActivityFragmentsBinding
import com.tool.master.presentation.fragment.flashlight.FlashlightFragment
import com.tool.master.presentation.fragment.info.InfoFragment
import com.tool.master.presentation.fragment.timer.TimerFragment
import com.tool.master.presentation.fragment.todo.TodoFragment
import com.orhanobut.hawk.Hawk
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentsBinding
    private val viewModel by viewModel<FragmentsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userName = Hawk.get("userName", "")
        binding.hiText.text = "Hi, $userName"
        viewModel.currentFragmentLive.observe(this) { fragment ->
            FragmentNavigator.openFragment(fragment, this)
        }
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            binding.title.text = menuItem.title
            val fragmentToOpen = when (menuItem.itemId) {
                R.id.nav_timer -> TimerFragment()
                R.id.nav_flashlight -> FlashlightFragment()
                R.id.nav_info -> InfoFragment()
                else -> TodoFragment()
            }
            viewModel.setCurrentFragment(fragmentToOpen)
            true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finishAffinity()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}