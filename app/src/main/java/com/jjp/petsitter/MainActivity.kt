package com.jjp.petsitter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jjp.petsitter.animals.ui.list.AnimalsFragment

class MainActivity : AppCompatActivity(), FragmentManipulator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(AnimalsFragment(), AnimalsFragment.TAG, false)
    }

    override fun addFragment(fragment: Fragment, tag: String, needBackStack: Boolean) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainContainer, fragment, tag).apply {
                if (needBackStack) addToBackStack(tag)
            }
            .commitAllowingStateLoss()
    }
}
