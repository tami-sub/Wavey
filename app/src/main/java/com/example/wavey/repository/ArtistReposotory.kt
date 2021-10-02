package com.example.wavey.repository

import com.example.wavey.artist.SafeApiRequest

class ArtistReposotory(private val api: LastFMApi): SafeApiRequest() {
    suspend fun getArtist() = apiRequest { api.getArtist() }
}