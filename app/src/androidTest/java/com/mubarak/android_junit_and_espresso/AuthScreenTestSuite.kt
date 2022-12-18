package com.mubarak.android_junit_and_espresso

import com.mubarak.android_junit_and_espresso.login.MainActivityScreenTest
import org.junit.experimental.categories.Categories
import org.junit.runner.RunWith
import org.junit.runners.Suite.SuiteClasses

@RunWith(Categories::class)
@Categories.IncludeCategory(AuthScreenTests::class)
@SuiteClasses(MainActivityScreenTest::class)
class AuthScreenTestSuite {
}