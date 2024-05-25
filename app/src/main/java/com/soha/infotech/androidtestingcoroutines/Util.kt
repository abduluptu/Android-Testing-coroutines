package com.soha.infotech.androidtestingcoroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Step2: Create a Util class
 */

//class Util {

// Constructor Injection
// From Application code we pass Dispatchers.IO & from test environment we pass testDispatcher
class Util(private val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName(): String {
        // 10 seconds
        delay(10000)
        return "Soha Infotech"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "User - Soha Infotech"
    }

    suspend fun getAddress(): String {
        withContext(dispatcher) {
            delay(5000)
        }
        return "Address"
    }

    //Note: not recommended code
    var globalArg = false
    fun getAddressDetail() {
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
    }

}