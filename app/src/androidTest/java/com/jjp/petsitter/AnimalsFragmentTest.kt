package com.jjp.petsitter

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jjp.petsitter.animals.ui.list.AnimalsFragment
import com.jjp.petsitter.animals.ui.list.adapter.AnimalUiModel
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.not

import androidx.test.espresso.matcher.ViewMatchers.withText

@RunWith(AndroidJUnit4::class)
class AnimalsFragmentTest {

    @Test
    fun showProgressBarWhenLoading() {
        FragmentScenario.launchInContainer(AnimalsFragment::class.java, Bundle())

        Espresso.onView(withId(R.id.animalsProgressBar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun showToastIfError()  {
        lateinit var activity: Activity

        val scenario = FragmentScenario.launchInContainer(AnimalsFragment::class.java, Bundle())
        scenario.onFragment { fragment ->
            activity = fragment.requireActivity()
            fragment.showError(fragment.getString(R.string.error))
        }

        Espresso.onView(withText(R.string.error))
            .inRoot(withDecorView(not(activity.window.decorView)))
            .check(matches(isDisplayed()))
    }

    @Test
    fun showDataIfSuccess() {

        val animalsList = listOf(
            AnimalUiModel(
                id = 1,
                icon = R.drawable.ic_dog,
                breed = "breed",
                address = "address"
            ),
            AnimalUiModel(
                id = 2,
                icon = R.drawable.ic_cat,
                breed = "breed",
                address = "address"
            )
        )

        val scenario = FragmentScenario.launchInContainer(AnimalsFragment::class.java, Bundle())
        scenario.onFragment { fragment ->
            fragment.setAnimals(animalsList)
        }

        Espresso.onView(withId(R.id.animalsRecycler))
            .check(RecyclerViewItemCountAssertion.withItemCount(animalsList.size))
    }
}
