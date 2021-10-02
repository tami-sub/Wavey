package com.example.wavey.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wavey.repository.SearchRepository
import com.example.wavey.search.Hit
import kotlinx.coroutines.*

class SearchRecyclerViewModel(private val repository: SearchRepository) : ViewModel() {

    private lateinit var job:Job

    private val _search = MutableLiveData<List<Hit>>()

    val search: MutableLiveData<List<Hit>> get() = _search

    fun getSearch() {
        job = CoroutineScope(Dispatchers.IO).async {
            _search.postValue(repository.getTrack().response.hits)
        }
//        Log.d("test", _search.value.toString())

    }

    override fun onCleared() {
        super.onCleared()

        if (::job.isInitialized) job.cancel()
    }
}