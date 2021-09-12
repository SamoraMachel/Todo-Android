package com.example.todoapp.Database

import android.content.Context
import androidx.room.Room

class TodoRepository(private val context : Context) : InterfaceRepo {
    private val database = Room.databaseBuilder(context, TodoDatabase::class.java, "todo-database").build()

    override suspend fun insert(vararg todo : Todo) {
        database.todoDao.insertTodo(*todo)
    }

    override suspend fun delete(vararg todo : Todo) {
        database.todoDao.deleteTodo(*todo)
    }

    override suspend fun getTodo(): List<Todo> {
        return database.todoDao.getAllTodo()
    }

    override suspend fun update(vararg todo : Todo) {
        database.todoDao.updateTodo(*todo)
    }

    suspend fun getDoneTodos() : List<Todo> {
        return database.todoDao.getTodoByDone(true)
    }

    suspend fun getUnfinishedTodo() : List<Todo> {
        return database.todoDao.getTodoByDone(false)
    }
}