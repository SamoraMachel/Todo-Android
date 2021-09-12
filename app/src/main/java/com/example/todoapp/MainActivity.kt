package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Database.Todo
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialDialogs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.add -> {
                    openDialog()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun openDialog() {
        val alertDialogue = TodoDialogue()
        alertDialogue.show(supportFragmentManager, alertDialogue.toString())
    }

}