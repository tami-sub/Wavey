package com.example.wavey.repository

import com.example.wavey.artist.SafeApiRequest
import retrofit2.http.GET

class SongRepository(private val api: SongLyricsApi): SafeApiRequest() {
    @GET("songs/3039923&?access_token=1nk7iO3htiVOj5icyW3vwo20gzHjtxfWwlhPDadlqdDvarqYJVbNak0v2Ruhfy2l")
    suspend fun getSong(trackId:String) = apiRequest { api.getSong(trackId) }
}