package com.retrofit.integration.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retrofit.integration.repository.MainRepository
import com.retrofit.integration.model.Post
import kotlinx.coroutines.launch

public class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> get() = _post

    fun getPost() {
        viewModelScope.launch {
            _post.value = repository.getPost()
        }
    }
}
