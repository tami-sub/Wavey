package com.example.wavey.repository

class SearchRepository(
    private val api: SearchLyricsApi,
    private val TrackTitle: String,
    private val song: SongRepository
): SafeApiRequest() {
    suspend fun getTrack() = apiRequest { api.getSource(TrackTitle) }
}