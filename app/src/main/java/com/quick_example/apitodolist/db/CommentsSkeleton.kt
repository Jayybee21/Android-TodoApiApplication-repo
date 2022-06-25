package com.quick_example.apitodolist.db

data class CommentsSkeleton(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)