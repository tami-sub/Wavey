package com.example.wavey.repository

class SongRepository(private val api: SongLyricsApi): SafeApiRequest() {

    suspend fun getSong(trackId:String) = apiRequest { api.getSong(trackId) }

//    @GET("songs/3039923&?access_token=1nk7iO3htiVOj5icyW3vwo20gzHjtxfWwlhPDadlqdDvarqYJVbNak0v2Ruhfy2l")
//    suspend fun getSong(trackId:String) = apiRequest { api.getSong(trackId) }


}