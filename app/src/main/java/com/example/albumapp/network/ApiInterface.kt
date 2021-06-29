package com.example.albumapp.network

import com.example.albumapp.data.PostModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("albums")
    fun fetchAllPosts(): Single<List<PostModel>>
}