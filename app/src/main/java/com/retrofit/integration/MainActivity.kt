package com.retrofit.integration

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.retrofit.integration.databinding.ActivityMainBinding
import com.retrofit.integration.repository.MainRepository
import com.retrofit.integration.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository = MainRepository()) as T
        }
    }
    private val viewModel: MainViewModel by viewModels{
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apiResponse.setOnClickListener{
            // Trigger the API call
            viewModel.getPost()
            binding.cardView.visibility = View.VISIBLE
        }

        // Observe changes in the LiveData
        viewModel.post.observe(this, Observer { post ->
            // Update UI with the post data
            for (i in 0 .. 1) {
                binding.textView.text = post.message?.toString()
            }
        })

    }
}

