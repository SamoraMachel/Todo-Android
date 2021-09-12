package com.example.todoapp.Database

import android.content.Context

interface InterfaceRepo {

    suspend fun insert(vararg todo : Todo)

    suspend fun delete(vararg todo : Todo)

    suspend fun getTodo() : List<Todo>

    suspend fun update(vararg todo : Todo)
}