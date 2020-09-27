package com.jjp.petsitter
import androidx.test.espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import com.jjp.petsitter.animals.ui.list.adapter.AnimalsViewHolder
import org.hamcrest.Matchers.`is`
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ContactForAdoptionScenarioTest {

    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun contactForAdoptionTest() {
        Espresso.onView(withId(R.id.animalsRecycler))
            .inRoot(
                RootMatchers.withDecorView(
                    `is`(activityRule.activity.window.decorView)
                )
            )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<AnimalsViewHolder>(
                    0,
                    ViewActions.click()
                )
            )

        Espresso.onView(withId(R.id.contactButton))
            .inRoot(
                RootMatchers.withDecorView(
                    `is`(activityRule.activity.window.decorView)
                )
            )
            .perform(
                ViewActions.click()
            )

        Intents.intended(toPackage("com.android.messaging"))
    }
}
