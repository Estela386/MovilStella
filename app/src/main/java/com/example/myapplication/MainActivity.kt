package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button
    lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize views after setContentView
        username = binding.username
        password = binding.password
        loginButton = binding.loginButton
        registerButton = binding.registerButton

        binding.loginButton.setOnClickListener {
//            if (binding.username.text.toString() == UserData.email && binding.password.text.toString() == UserData.password) {
            if (binding.username.text.toString() == "a" && binding.password.text.toString() == "a") {
                Toast.makeText(this, "Login successful.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MenuuActivity::class.java) // Ensure MenuActivity exists
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login went wrong.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}