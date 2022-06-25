package com.quick_example.apitodolist.db

data class PostsSkeleton(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)