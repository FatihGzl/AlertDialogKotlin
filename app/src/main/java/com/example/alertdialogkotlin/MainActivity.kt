package com.example.alertdialogkotlin

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1) Toast 2) AlertDialog 3) Snackbar

        //Context
        //Activity Context -> this
        //Application Context -> applicationContext

        Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_SHORT).show()

        /*
        //lambda

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            println("button clicked")
        }

        //interface

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                println("")
            }
        })
        */

    }

    fun save(view : View) {

        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Save")
        alert.setMessage("Are you sure ?")
        alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_LONG).show()
            }
        })

        alert.setNegativeButton("No") { p0, p1 ->
            Toast.makeText(this@MainActivity, "Not Saved", Toast.LENGTH_LONG).show()
        }

        alert.show()

    }

}