package com.example.wavey.ui.favorites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.wavey.data.Track
import com.example.wavey.data.TrackDatabase
import com.example.wavey.data.TrackRepository

class FavoritesSavedViewModel(application: Application): AndroidViewModel(application) {
    private val _readAllData: LiveData<List<Track>>
    val readAllData: LiveData<List<Track>> get() = _readAllData
    private val repository: TrackRepository


    init{
        val trackDao = TrackDatabase.getDatabase(application).trackDao()
        repository = TrackRepository(trackDao)
        _readAllData = repository.readAllData
    }
}