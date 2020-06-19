package com.jjp.petsitter.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jjp.petsitter.R
import com.jjp.petsitter.profile.data.Profile
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    private val profileObserver = Observer<Profile> { profile ->
        saveButton.setNormalState()
        setProfile(profile)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel.profile.observe(viewLifecycleOwner, profileObserver)
        profileViewModel.loadProfile()

        saveButton.setOnClickListener {
            saveButton.setLoadingState()
            profileViewModel.saveProfile()
        }
    }

    private fun setProfile(profile: Profile) {
        // TODO
    }
}
