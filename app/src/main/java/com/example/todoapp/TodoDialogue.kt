package com.example.todoapp

import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.todoapp.Database.Todo
import com.example.todoapp.Database.TodoRepository
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TodoDialogue : DialogFragment(){
    lateinit var todoInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_todo_dialogue, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todoInput = view.findViewById(R.id.todoInput)

        var createTodo = view.findViewById<Button>(R.id.todoCreateBtn)
        var cancelTodoBtn = view.findViewById<Button>(R.id.todoCancelBtn)

        createTodo.setOnClickListener {
            if (todoInput.text != null) {
                saveTodo(todoInput.text.toString())
            }
            myAdapter.notifyDataSetChanged()
        }

        cancelTodoBtn.setOnClickListener {
            cancelTodo()
        }

    }

    private fun saveTodo(title : String) {
        if (title.length > 2) {
            dismiss()
        }
        val newTodo = Todo(title, false)
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            TodoRepository(requireContext()).insert(newTodo)
        }
        dismiss()
    }

    private fun cancelTodo() {
        dismiss()
    }






}