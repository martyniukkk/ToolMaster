package com.tool.master.data.flashlight_manager

import android.content.Context
import android.hardware.camera2.CameraManager

class FlashlightManagerImpl(context: Context) : FlashlightManager {

    private val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    private fun enableOrDisableLight(enabled: Boolean): Boolean {
        try {
            cameraManager.setTorchMode(cameraManager.cameraIdList[0], enabled)
            return true
        } catch (ex: Exception) {
            return false
        }
    }

    override fun enable(): Boolean {
        return enableOrDisableLight(true)
    }

    override fun disable(): Boolean {
        return enableOrDisableLight(false)
    }
}