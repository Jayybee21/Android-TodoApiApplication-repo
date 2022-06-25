package com.quick_example.apitodolist.db

data class TodoSkeleton(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)