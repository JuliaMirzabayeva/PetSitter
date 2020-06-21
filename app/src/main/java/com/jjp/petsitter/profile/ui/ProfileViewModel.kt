package com.jjp.petsitter.profile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjp.petsitter.profile.data.Profile

class ProfileViewModel : ViewModel() {

    private val _profile = MutableLiveData<Profile>()

    val profile: LiveData<Profile>
        get() = _profile

    fun loadProfile() {
        // TODO
    }

    fun saveProfile() {
        // TODO
    }
}
