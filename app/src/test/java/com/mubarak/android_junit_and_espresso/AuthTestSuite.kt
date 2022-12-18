package com.mubarak.android_junit_and_espresso

import com.mubarak.android_junit_and_espresso.login.MainActivityTest
import org.junit.experimental.categories.Categories
import org.junit.runner.RunWith
import org.junit.runners.Suite.SuiteClasses


@RunWith(Categories::class)
@Categories.IncludeCategory(AuthTests::class)
@SuiteClasses(MainActivityTest::class)
// Note that Categories is a kind of Suite
public class AuthTestSuite {
    // Will run Test cases which includes SlowTests but not FastTests
}