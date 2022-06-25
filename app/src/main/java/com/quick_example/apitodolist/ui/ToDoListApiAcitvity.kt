package com.quick_example.apitodolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quick_example.apitodolist.databinding.ActivityToDoListApiAcitvityBinding

class ToDoListApiAcitvity : AppCompatActivity() {
    private lateinit var binding: ActivityToDoListApiAcitvityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoListApiAcitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}