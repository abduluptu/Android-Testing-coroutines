package com.soha.infotech.androidtestingcoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Step3: Create a UtilTest class
 */

class UtilTest {

    // It will work when we need for  Dispatcher test
    // private val testDispatcher = StandardTestDispatcher()

    @get: Rule
    val mainCoroutineRule = MainCoroutineRule()

    /* @Before
     fun setUp() {
         Dispatchers.setMain(testDispatcher)
     }*/

    @Test
    fun testUser() {
        // Arrange
        // val sut = Util()
        // Act
        // runBlocking is not good for testing coroutines
        /*runBlocking {
            sut.getUserName()
        }*/

        // runTest avoid delays (runTest is best to test coroutines)
        /* runTest {
             sut.getUserName()
         }*/

        //------------------------------------------------------------
        // Arrange
        //val sut = Util(testDispatcher)

        // Act
        /* runTest {
             sut.getUser()
         }*/
    }

    @Test
    fun testUser2() {
        // Arrange
        val sut = Util(mainCoroutineRule.testDispatcher)
        // Act
        /*runTest {
           // sut.getAddress()
            sut.getUser()
        }*/

        // Note: not recommended
        runTest {
            // Act
            sut.getAddressDetail()
            // advanceUntilIdle() -> Runs the new coroutines
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            // Assert
            assertEquals(true, sut.globalArg)
        }

    }

    /* @After
     fun tearDown() {
         Dispatchers.resetMain()
     }*/
}