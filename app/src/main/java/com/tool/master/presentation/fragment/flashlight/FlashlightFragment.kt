package com.tool.master.presentation.fragment.flashlight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tool.master.databinding.FragmentFlashlightBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class FlashlightFragment : Fragment() {

    private lateinit var binding: FragmentFlashlightBinding
    private val viewModel by activityViewModel<FlashlightViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlashlightBinding.inflate(layoutInflater)
        viewModel.flashlightEnabledStateLive.observe(viewLifecycleOwner) {
            binding.flashPower.isActivated = !it
        }
        binding.flashPower.setOnClickListener {
            if (it.isActivated) {
                viewModel.enableFlashlight()
            } else {
                viewModel.disableFlashlight()
            }
        }
        return binding.root
    }
}