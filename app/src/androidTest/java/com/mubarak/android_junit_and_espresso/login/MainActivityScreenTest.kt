package com.mubarak.android_junit_and_espresso.login

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.mubarak.android_junit_and_espresso.AuthScreenTests
import com.mubarak.android_junit_and_espresso.MainActivity
import com.mubarak.android_junit_and_espresso.R
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
@Category(AuthScreenTests::class)
class MainActivityScreenTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>


    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.moveToState(Lifecycle.State.RESUMED)
    }

    @After
    fun tearDown() {

    }

   /* @Test
    fun checkedTestCaseRun() {
        assertEquals(true, true)
    }*/

    @Test
    fun emptyEmailPassword() {
        val errorMsg = "Please Enter Email/Password"
        onView(withId(R.id.edtEmail)).perform(typeText(""))
        onView(withId(R.id.edtPassword)).perform(typeText(""))
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withText(errorMsg)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(1500)
    }

    @Test
    fun emptyPassword() {
        val errorMsg = "Please Enter Password"
        onView(withId(R.id.edtEmail)).perform(typeText("Mubarak@gmail.com"))
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withText(errorMsg)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(1500)
    }

    @Test
    fun emptyEmail() {
        val errorMsg = "Please Enter Email"
        onView(withId(R.id.edtPassword)).perform(typeText("Admin@123"))
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withText(errorMsg)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(1500)
    }

    @Test
    fun validEmail() {
        val errorMsg = "Please enter a valid email"
        onView(withId(R.id.edtEmail)).perform(typeText("Mubarak@"))
        onView(withId(R.id.edtPassword)).perform(typeText("Mubarak@123"))
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withText(errorMsg)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(1500)
    }


    @Test
    fun validPassword() {
        val errorMsg = "Please enter a valid password"
        onView(withId(R.id.edtEmail)).perform(typeText("Mubarak@gmail.com"))
        onView(withId(R.id.edtPassword)).perform(typeText("Admin1"))
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withText(errorMsg)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(1500)
    }

    @Test
    fun successfullyLogin() {
        val errorMsg = "Login Successfully"
        onView(withId(R.id.edtEmail)).perform(typeText("Mubarak@gmail.com"))
        onView(withId(R.id.edtPassword)).perform(typeText("Admin@123"))
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withText(errorMsg)).check(ViewAssertions.matches(isDisplayed()))
        Thread.sleep(1500)    }
}