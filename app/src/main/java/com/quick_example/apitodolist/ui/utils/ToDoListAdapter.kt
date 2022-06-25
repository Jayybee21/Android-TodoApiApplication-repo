package com.quick_example.apitodolist.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.quick_example.apitodolist.databinding.SingleItemToDoListApiBinding
import com.quick_example.apitodolist.db.TodoSkeleton
import com.quick_example.apitodolist.ui.ToDoListApiAcitvity

class ToDoListAdapter: RecyclerView.Adapter<ToDoListAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding:SingleItemToDoListApiBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(SingleItemToDoListApiBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    //new function used to reduce api callback time if already exits
    private val diffCallBack = object : DiffUtil.ItemCallback<TodoSkeleton>(){
        override fun areItemsTheSame(oldItem: TodoSkeleton, newItem: TodoSkeleton): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: TodoSkeleton, newItem: TodoSkeleton): Boolean {
            return oldItem == newItem
        }
    }
    //next we call this function to check fr us the values
    private val differ = AsyncListDiffer(this,diffCallBack)

    //lastly we either get or set our values
    var todos : List<TodoSkeleton>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            txtSingleItem.text = todos[position].title
            chkboxSingleItem.isChecked = todos[position].completed
        }
     }
    override fun getItemCount() = todos.size

}