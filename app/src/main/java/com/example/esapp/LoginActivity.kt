package com.example.esapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton
    private lateinit var tvRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegister = findViewById(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val usernameInput = etUsername.text.toString().trim()
            val passwordInput = etPassword.text.toString().trim()

            if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", null)
            val savedPassword = sharedPref.getString("password", null)

            if (savedUsername == null || savedPassword == null) {
                Toast.makeText(this, "Belum ada akun terdaftar, silakan daftar dulu", Toast.LENGTH_SHORT).show()
            } else if (usernameInput == savedUsername && passwordInput == savedPassword) {
                // Login berhasil
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
