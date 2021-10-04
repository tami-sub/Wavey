package com.example.wavey.repository

class SearchRepository(
    private val api: SearchLyricsApi,
    private val TrackTitle: String,
    private val song: SongRepository
): SafeApiRequest() {
    suspend fun getTrack() = apiRequest { api.getSource(TrackTitle) }

//    suspend fun getVideoURL(songId:String): String {
//        song.getSong(songId).response.song.media.forEach { if (it.provider == "youtube") return it.url }
//        return "There is no video clip"
//    }

}