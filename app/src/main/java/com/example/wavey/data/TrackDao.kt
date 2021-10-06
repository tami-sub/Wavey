package com.example.wavey.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrack(track:Track)

    @Delete()
    suspend fun deleteTrack(track:Track)

    @Query("SELECT * FROM track_table")
    fun readAllData(): LiveData<List<Track>>
}