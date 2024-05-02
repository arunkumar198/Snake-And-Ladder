package com.rcd.myapplication

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import kotlinx.coroutines.*

class instruction : AppCompatActivity() {
    var backButton : Button? = null
    var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction)
        backButton = findViewById(R.id.backButton)
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(false)

        backButton?.setOnClickListener {
            progressDialog?.show()
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                progressDialog?.dismiss()
                navigateToMainActivity()
            }
        }
    }
    fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}