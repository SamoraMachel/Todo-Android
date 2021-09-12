package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Database.Todo

class TodoAdapter(val todoList : List<Todo>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView) {
        var todoCheckList = itemView.findViewById<CheckBox>(R.id.todoDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: TodoAdapter.ViewHolder, position: Int) {
        val item = todoList[position]

        holder.todoCheckList.text = item.title
        holder.todoCheckList.isChecked = item.done
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

}