package com.example.wavey.data

import androidx.lifecycle.LiveData

class TrackRepository (private val trackDao: TrackDao) {

    val readAllData: LiveData<List<Track>> = trackDao.readAllData()

    suspend fun addTrack(track: Track){
        trackDao.addTrack(track)
    }

    suspend fun deleteTrack(track: Track){
        trackDao.deleteTrack(track)
    }
}