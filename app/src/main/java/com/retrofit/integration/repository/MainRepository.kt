package com.retrofit.integration.repository

import com.retrofit.integration.retrofit.RetrofitInstance
import com.retrofit.integration.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {
    suspend fun getPost(): Post {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.apiService.getPost()
        }
    }
}
