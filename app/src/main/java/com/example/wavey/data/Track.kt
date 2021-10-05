package com.example.wavey.data

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "track_table",

    indices = [(Index(value = ["trackId"], unique = true))])
data class Track (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val trackId: Int,
    val title: String,
    val owner: String,
    val text: String,
    val image:Bitmap)