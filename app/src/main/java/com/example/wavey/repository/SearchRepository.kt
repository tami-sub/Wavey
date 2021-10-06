package com.example.wavey.repository

class SearchRepository(
    private val api: SearchLyricsApi,
    private val TrackTitle: String,
): SafeApiRequest() {
    suspend fun getTrack() = apiRequest { api.getSource(TrackTitle) }
}