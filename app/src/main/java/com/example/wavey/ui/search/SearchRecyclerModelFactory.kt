package com.example.wavey.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wavey.repository.SearchRepository

class SearchRecyclerModelFactory(private val repository: SearchRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchRecyclerViewModel(repository) as T
    }
}