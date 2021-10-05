package com.example.wavey.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TrackDao {
    @Insert()
    suspend fun addTrack(track:Track)

    @Delete()
    suspend fun deleteTrack(track:Track)

    @Query("SELECT * FROM track_table")
    fun readAllData(): LiveData<List<Track>>
}