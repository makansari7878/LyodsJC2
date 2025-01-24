package com.example.lyodsjc2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class NormalActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
        btnRegister = findViewById(R.id.buttonNext)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            val registrationResult = RegistrationUtil.validateRegistrationInput(username, password, confirmPassword)

            if (registrationResult.isSuccessful) {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, registrationResult.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

// RegistrationUtil.kt
object RegistrationUtil {

    var existingUsers = listOf("abc", "xyz")

    data class RegistrationResult(val isSuccessful: Boolean, val errorMessage: String)

    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmPassword: String,
    ): RegistrationResult {
        if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return RegistrationResult(false, "Please fill in all fields")
        }

        if (userName in existingUsers) {
            return RegistrationResult(false, "Username already exists")
        }

        fun hasAtLeastTwoCharacters(password: String): Boolean {
            return password.length >= 3
        }

        if (!hasAtLeastTwoCharacters(password)) {
            return RegistrationResult(false, "Password must be at least 3 characters long")
        }

        if (!password.contains(Regex("\\d{2,}"))) {
            return RegistrationResult(false, "Password must contain at least 2 digits")
        }

        if (password != confirmPassword) {
            return RegistrationResult(false, "Passwords do not match")
        }

        return RegistrationResult(true, "")
    }
}