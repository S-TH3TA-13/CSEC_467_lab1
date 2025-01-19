package com.csec464.lab01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the EditText and Button
        val editText = findViewById<EditText>(R.id.editText)
        val launchButton = findViewById<Button>(R.id.launchButton)

        // Set a click listener on the button
        launchButton.setOnClickListener {
            // Get the text from the EditText
            val textToPass = editText.text.toString()

            // Create an Intent to start the SecondActivity
            val intent = Intent(this@MainActivity, SecondActivity::class.java)

            // Add the text as an extra to the Intent
            intent.putExtra("TEXT_EXTRA", textToPass)

            // Start the SecondActivity
            startActivity(intent)
        }
    }
}

class SecondActivity :ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Get the text from the Intent's extras
        val receivedText = intent.getStringExtra("TEXT_EXTRA")

        // Get a reference to the button
        val showTextButton = findViewById<Button>(R.id.showTextButton)

        // Set a click listener on the button
        showTextButton.setOnClickListener {
            // Display the received text in a Toast
            Toast.makeText(this@SecondActivity, receivedText, Toast.LENGTH_LONG).show()
        }
    }
}
