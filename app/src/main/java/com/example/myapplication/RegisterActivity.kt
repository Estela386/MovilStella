package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.UserData
import java.util.regex.Pattern


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Referencias a los campos de entrada
        val nameField: EditText = findViewById(R.id.name)
        val emailField: EditText = findViewById(R.id.email)
        val passwordField: EditText = findViewById(R.id.password)
        val birthdateField: EditText = findViewById(R.id.birthdate)
        val loginButton: Button = findViewById(R.id.login_button)

        fun isValidEmail(email: String): Boolean {
            val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
            return Pattern.compile(emailRegex).matcher(email).matches()
        }

        fun isValidDate(date: String): Boolean {
            // Puedes usar una librería como Joda-Time o la clase LocalDate de Java 8 para una validación más robusta
            val datePattern = "^\\d{2}/\\d{2}/\\d{4}$"
            return Pattern.compile(datePattern).matcher(date).matches()
        }

        fun isValidPassword(password: String): Boolean {
            // Una contraseña robusta debería tener una combinación de mayúsculas, minúsculas, números y caracteres especiales
            val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
            return Pattern.compile(passwordRegex).matcher(password).matches()
        }

        // Configuración del botón
        loginButton.setOnClickListener {
            val name = nameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            val birthdate = birthdateField.text.toString()

            // Validar campos
            if (name.isEmpty()) {
                nameField.error = "El nombre es obligatorio"
                return@setOnClickListener
            }

            if (email.isEmpty() || !isValidEmail(email)) {
                emailField.error = "El correo no es válido"
                return@setOnClickListener
            }

            if (password.isEmpty() || !isValidPassword(password)) {
                passwordField.error = "La contraseña debe tener al menos 8 caracteres y contener mayúsculas, minúsculas, números y caracteres especiales"
                return@setOnClickListener
            }

            if (birthdate.isEmpty() || !isValidDate(birthdate)) {
                birthdateField.error = "La fecha de nacimiento debe tener el formato DD/MM/AAAA"
                return@setOnClickListener
            }

            // Mostrar mensaje de registro exitoso
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            val username = "usuario123"
            Log.i("MainActivity", "El nombre de usuario es: $username")


            UserData.name = name
            UserData.email = email
            UserData.password = password
            UserData.birthdate = birthdate

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
