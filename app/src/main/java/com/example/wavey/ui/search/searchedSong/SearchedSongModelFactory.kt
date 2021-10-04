package com.example.wavey.ui.search.searchedSong

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wavey.repository.SongRepository

class SearchedSongModelFactory(private val repository: SongRepository, private val trackId:String) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchedSongViewModel(repository,trackId) as T
    }
}