package com.example.wavey.ui.randomSong

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wavey.repository.SongRepository

class RandomSongModelFactory(
    private val repository: SongRepository,
    private val trackId: String
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RandomSongViewModel(repository, trackId) as T
    }
}