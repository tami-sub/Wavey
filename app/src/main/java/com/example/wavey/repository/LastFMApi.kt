package com.example.wavey.repository

import com.example.wavey.artist.ArtistResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface LastFMApi {

    @GET("?method=artist.search&artist=joji&api_key=e3d8c9ea33f6b40be4f82245781d1ce9&format=json")
    suspend fun getArtist(): Response<ArtistResponse>

//    @GET("posts")
//    suspend fun getArtist(): Response<Testing>

    companion object {
        operator fun invoke(): LastFMApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://jsonplaceholder.typicode.com/")
                .baseUrl("https://ws.audioscrobbler.com/2.0/")
//                .baseUrl("http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=YOUR_API_KEY&artist=cher&track=believe&format=json")
                .build().create(LastFMApi::class.java)
        }
    }


}