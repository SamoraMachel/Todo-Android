package com.example.todoapp.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Todo (var title : String, var done : Boolean = false){
    @PrimaryKey(autoGenerate = true)
    lateinit var id : Integer
}