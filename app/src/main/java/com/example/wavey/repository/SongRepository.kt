package com.example.wavey.repository

class SongRepository(private val api: SongLyricsApi): SafeApiRequest() {

    suspend fun getSong(trackId:String) = apiRequest { api.getSong(trackId) }
}