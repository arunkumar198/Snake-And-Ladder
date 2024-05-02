package com.rcd.myapplication

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var start: Button? = null
    var instructions : Button? = null
    var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start = findViewById(R.id.start)
        instructions = findViewById(R.id.Instructions)

        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(false)

        // Example of how to start loading
        instructions?.setOnClickListener {
            progressDialog?.show()
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                progressDialog?.dismiss()
                navigateToInstuction()
            }
        }
        start?.setOnClickListener {
            progressDialog?.show()
            CoroutineScope(Dispatchers.Main).launch {
                delay(3000)
                progressDialog?.dismiss()
                navigateToMainActivity()
            }
        }
    }


    fun navigateToMainActivity() {
//        startLoading()
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }

    fun navigateToInstuction(){
        val intent = Intent(this, instruction::class.java)
        startActivity(intent)
        finish()
    }
}