package com.tool.master.presentation.activity.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tool.master.presentation.fragment.todo.TodoFragment

class FragmentsViewModel : ViewModel() {

    private val _currentFragmentLive = MutableLiveData<Fragment>()
    val currentFragmentLive: LiveData<Fragment> = _currentFragmentLive

    fun setCurrentFragment(fragment: Fragment) {
        _currentFragmentLive.value = fragment
    }

    init {
        _currentFragmentLive.value = TodoFragment()
    }
}