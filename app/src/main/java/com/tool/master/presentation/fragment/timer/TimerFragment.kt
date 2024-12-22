package com.tool.master.presentation.fragment.timer

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.kongzue.dialogx.dialogs.PopTip
import com.tool.master.databinding.FragmentTimerBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class TimerFragment : Fragment() {

    private lateinit var binding: FragmentTimerBinding
    private val viewModel by activityViewModel<TimerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTimerBinding.inflate(layoutInflater)
        binding.start.setOnClickListener {
            if (binding.start.text.toString().uppercase() == "START") {
                val time = binding.editText.text.toString()
                if (time.isNotEmpty()) {
                    val millis = timeToMillis(time)
                    viewModel.saveProgressMax(millis.toFloat())
                    viewModel.startTimer(millis, 1000L)
                } else {
                    PopTip.show("Please enter time first")
                }
            } else {
                viewModel.stopTimer()
            }
        }
        viewModel.timeLeft.observe(viewLifecycleOwner) { millisLeft ->
            binding.timerText.text = millisToTime(millisLeft)
            binding.circularProgressBar.progress = millisLeft.toFloat()
        }
        viewModel.isFinished.observe(viewLifecycleOwner) { isFinished ->
            if (isFinished) {
                binding.circularProgressBar.progress = 0f
                viewModel.resetTimeLeft()
            } else {
                requireActivity().hideKeyboard()
            }
            binding.start.text = if (isFinished) "START" else "STOP"
            binding.editText.isVisible = isFinished
        }
        viewModel.progressMaxLive.observe(viewLifecycleOwner) {
            binding.circularProgressBar.progressMax = it
        }
        viewModel.editTextValueLive.observe(viewLifecycleOwner) {
            binding.editText.setText(it)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.setEditTextValue(binding.editText.text.toString())
    }

    private fun Activity.hideKeyboard() {
        val view: View? = this.currentFocus
        view?.let {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    @SuppressLint("DefaultLocale")
    private fun millisToTime(millis: Long): String {
        val hours = millis / 3600000
        val minutes = (millis % 3600000) / 60000
        val seconds = (millis % 60000) / 1000
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    private fun timeToMillis(time: String): Long {
        val parts = time.split(":").map { it.toIntOrNull() ?: 0 }
        var hours = 0
        var minutes = 0
        var seconds = 0
        when (parts.size) {
            3 -> {
                hours = parts[0]
                minutes = parts[1] + parts[2] / 60
                seconds = parts[2] % 60
            }

            2 -> {
                hours = parts[0]
                minutes = parts[1]
            }

            1 -> {
                hours = parts[0]
            }
        }
        hours += minutes / 60
        minutes %= 60
        return (hours * 3600000L) + (minutes * 60000L) + (seconds * 1000L)
    }
}