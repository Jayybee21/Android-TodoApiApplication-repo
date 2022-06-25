package com.quick_example.apitodolist.service

import com.quick_example.apitodolist.db.*
import retrofit2.Response
import retrofit2.http.GET

interface APIGetters {


    @GET("/todos")
    suspend fun getTodos() : Response<List<TodoSkeleton>>
    @GET("/posts")
    suspend fun getPosts() : Response<List<PostsSkeleton>>
    @GET("/comments")
    suspend fun getComments() : Response<List<CommentsSkeleton>>
    @GET("/albums")
    suspend fun getAlbums() : Response<List<AlbumsSkeleton>>
    @GET("/photos")
    suspend fun getPhotos() : Response<List<PhotosSkeleton>>
}