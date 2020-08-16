package com.jjp.petsitter

import androidx.fragment.app.Fragment

interface FragmentManipulator {

    fun addFragment(fragment: Fragment, tag: String, needBackStack: Boolean = true)
}
