package com.example.mockkvalidation.utils

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class OperationsTest {
    /*
    * This function is used to test MockK functions
    * such as every, verify, verifySequence, and
    * confirmVerified
    * */
    @Test
    fun addTest() {
        val operations = mockk<Operations>()

        // Stubbing the behavior of the add method
        every {operations.add("10","9")} returns 19

        // Calling the add method
        val answer = operations.add("10","9")

        // Verifying that the add method was called exactly once with the expected arguments
        verify {operations.add("10","9")  }

        // Variables to capture the arguments of the add method
        val capturedArgs1 = mutableListOf<String>()
        val capturedArgs2 = mutableListOf<String>()
        every { operations.add(capture(capturedArgs1), capture(capturedArgs2)) } returns 0

        // Verifying that the add method was not called with unexpected arguments
        Assert.assertEquals(0, capturedArgs1.size)
        Assert.assertEquals(0, capturedArgs2.size)

        // Verifying that the add method was not called with different arguments
        verify(inverse = true) { operations.add("4", "5") }

        // Verifying that the add method was called once with any arguments
        verify(exactly = 1) { operations.add(any(), any()) }

        // Verifying that the add method was not called more than once
        verify(atMost = 1) { operations.add(any(), any()) }

        // Verifying that the add method was not called less than once
        verify(atLeast = 1) { operations.add(any(), any()) }

        // Verifying that the add method was called once with the expected arguments and no others
        verifySequence { operations.add("10", "9") }

        // Verifying that no other methods were called on the mock object
        confirmVerified(operations)

        Assert.assertEquals(19, answer)
    }

    /*
    * This function is used to test MockK functions
    * such as every, verify, verifySequence, and
    * confirmVerified
    * */
    @Test
    fun subtractTest() {
        val operations = mockk<Operations>()

        // Stubbing the behavior of the add method
        every {operations.subtract("12","5")} returns 7

        // Calling the subtract method
        val answer = operations.subtract("12","5")

        // Verifying that the subtract method was called exactly once with the expected arguments
        verify {operations.subtract("12","5")  }

        // Variables to capture the arguments of the subtract method
        val capturedArgs1 = mutableListOf<String>()
        val capturedArgs2 = mutableListOf<String>()
        every { operations.subtract(capture(capturedArgs1), capture(capturedArgs2)) } returns 0

        // Verifying that the subtract method was called exactly once with the expected arguments
        verify {operations.subtract("12","5")  }

        // Verifying that the subtract method was not called with unexpected arguments
        Assert.assertEquals(0, capturedArgs1.size)
        Assert.assertEquals(0, capturedArgs2.size)

        // Verifying that the subtract method was not called with different arguments
        verify(inverse = true) { operations.subtract("10", "5") }

        // Verifying that the subtract method was called once with any arguments
        verify(exactly = 1) { operations.subtract(any(), any()) }

        // Verifying that the subtract method was not called more than once
        verify(atMost = 1) { operations.subtract(any(), any()) }

        // Verifying that the subtract method was not called less than once
        verify(atLeast = 1) { operations.subtract(any(), any()) }

        // Verifying that the add method was called once with the expected arguments and no others
        verifySequence { operations.subtract("12", "5") }

        // Verifying that no other methods were called on the mock object
        confirmVerified(operations)

        Assert.assertEquals(7, answer)
    }

    /*
    * This function is used to test MockK functions
    * such as runBlocking, coEvery, coVerify and
    * confirmVerified to mock suspended function
    * */
    @Test
    fun testProcessData() = runBlocking {
        val operations = mockk<Operations>()
        // Using coEvery to mock a suspend function and return a specific value
        coEvery { operations.processData() } returns 4

        // Calling the suspend function and asserting the result
        val result = operations.processData()
        Assert.assertEquals(4, result)

        // Verifying that the suspend function was called
        coVerify { operations.processData() }

        // Verifying that no other suspend functions were called on the spy
        confirmVerified(operations)
    }
}