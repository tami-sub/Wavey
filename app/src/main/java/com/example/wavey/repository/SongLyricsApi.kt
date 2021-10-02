package com.example.wavey.repository

import com.example.wavey.song.Song
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SongLyricsApi {


    @GET("songs/{id}&?access_token=1nk7iO3htiVOj5icyW3vwo20gzHjtxfWwlhPDadlqdDvarqYJVbNak0v2Ruhfy2l")
    suspend fun getSong(@Path("id") page: String): Response<Song>

    companion object {
        operator fun invoke(): SongLyricsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.genius.com/")
                .build().create(SongLyricsApi::class.java)
        }
    }


}