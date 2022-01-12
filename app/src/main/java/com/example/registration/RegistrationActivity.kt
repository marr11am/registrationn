package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextRepeatPassword: EditText
    private lateinit var button_registration: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        init()

        registrationListeners()
    }

    private fun init() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword)
        button_registration = findViewById(R.id.button_registration)
    }

    private fun registrationListeners() {
        button_registration.setOnClickListener { 
            
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val passwordsec = editTextRepeatPassword.text.toString()
            
            if (email.isEmpty() || password.isEmpty() || passwordsec.isEmpty()) {
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.equals(passwordsec)) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    task ->
                  if (task.isSuccessful) {
                      startActivity(Intent(this, RegistrationActivity::class.java ))
                      finish()
                }
        }

            }
            }
        }
    }