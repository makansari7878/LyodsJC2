package com.example.lyodsjc2

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun emptyUsernameTest() {
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result.isSuccessful).isFalse()
        assertThat(result.errorMessage).isEqualTo("Please fill in all fields")
    }

    @Test
    fun usernameAlreadyExsistTest() {
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "xyz",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result.isSuccessful).isFalse()
        assertThat(result.errorMessage).isEqualTo("Username already exists")
    }

    @Test
    fun `password with less than 3 characters returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "test",
            password = "a",
            confirmPassword = "a"
        )
        assertThat(result.isSuccessful).isFalse()
        assertThat(result.errorMessage).isEqualTo("Password must be at least 3 characters long")
    }

    @Test
    fun `password with less than 2 digits returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "test",
            password = "a1q",
            confirmPassword = "a1q"
        )
        assertThat(result.isSuccessful).isFalse()
        assertThat(result.errorMessage).isEqualTo("Password must contain at least 2 digits")
    }

    @Test
    fun validateUsernameAndRepeatPasswordTest() {
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "lmn",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result.isSuccessful).isTrue()
        assertThat(result.errorMessage).isEqualTo("")
    }
}