package com.example.todoapp.Database

import androidx.room.*

@Dao
interface TodoDao {
    @Query("Select * from todo")
    fun getAllTodo() : List<Todo>

    @Query("Select * from todo where done=:done")
    fun getTodoByDone(done : Boolean) : List<Todo>

    @Insert
    fun insertTodo(vararg todo : Todo)

    @Delete
    fun deleteTodo(vararg todo : Todo)

    @Update
    fun updateTodo(vararg todo : Todo)
}