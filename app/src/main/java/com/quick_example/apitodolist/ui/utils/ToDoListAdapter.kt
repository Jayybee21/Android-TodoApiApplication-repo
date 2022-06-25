package com.quick_example.apitodolist.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quick_example.apitodolist.databinding.SingleItemToDoListApiBinding
import com.quick_example.apitodolist.db.TodoSkeleton

class ToDoListAdapter(var items:List<TodoSkeleton>): RecyclerView.Adapter<ToDoListAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding:SingleItemToDoListApiBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(SingleItemToDoListApiBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        var currentToDoItem = items[position]
        holder.binding.txtSingleItem.text = currentToDoItem.title
        holder.binding.chkboxSingleItem.isChecked = currentToDoItem.completed
     }
    override fun getItemCount(): Int {
        return items.size
    }
}