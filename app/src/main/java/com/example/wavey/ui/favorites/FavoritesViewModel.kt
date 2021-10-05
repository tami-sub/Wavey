package com.example.wavey.ui.favorites

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.wavey.data.Track
import com.example.wavey.data.TrackDatabase
import com.example.wavey.data.TrackRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(application:Application): AndroidViewModel(application) {
    private val _readAllData: LiveData<List<Track>>
    val readAllData: LiveData<List<Track>> get() = _readAllData
    private val repository: TrackRepository
    init{
        val trackDao = TrackDatabase.getDatabase(application).trackDao()
        repository = TrackRepository(trackDao)
        _readAllData = repository.readAllData
        Log.d("test", TrackDatabase.getDatabase(application).openHelper.writableDatabase.path)
    }

    fun addTrack(track: Track){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTrack(track)
        }
    }

    fun deleteTrack(track: Track){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTrack(track)
        }
    }
}