package com.example.todoapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.Database.Todo
import com.example.todoapp.Database.TodoRepository
import kotlinx.coroutines.*

class TodoViewModel(val context : Context) : ViewModel() {


    private val deferred = viewModelScope.async {
        val scope = CoroutineScope(Dispatchers.Default)
        val deferredList = scope.async {
            getList()
        }
        deferredList.await()
    }

    private val todoList = suspend {
        deferred.await()
    }
    val todoAdapter = suspend {
        getAdapter()
    }

    private suspend fun getList() =  TodoRepository(context).getUnfinishedTodo()

    private suspend fun getAdapter() : TodoAdapter = TodoAdapter(todoList.invoke())

}