package com.retrofit.integration.retrofit
import com.retrofit.integration.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("breeds/list/all")
    suspend fun getPost(): Post
}