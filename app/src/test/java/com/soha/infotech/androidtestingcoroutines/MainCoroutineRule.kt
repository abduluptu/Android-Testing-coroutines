package com.soha.infotech.androidtestingcoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Step4: Create a CoroutineRule class with the help of that we make coroutines rules.
 * We write code once and use many times in test environment,
 * We need not to write code again & again for every test case of test class
 */

class MainCoroutineRule : TestWatcher() {
    val testDispatcher = StandardTestDispatcher()

    // Represent @Before
    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    // Represent @After
    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}