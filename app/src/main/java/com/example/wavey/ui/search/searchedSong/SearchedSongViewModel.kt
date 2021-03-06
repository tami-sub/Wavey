package com.example.wavey.ui.search.searchedSong

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wavey.repository.SongRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist

class SearchedSongViewModel(private val repository: SongRepository, private val trackId: String) :
    ViewModel() {

    private lateinit var job: Job
    private val _getURL = MutableLiveData<String>()
    val getURL: MutableLiveData<String> get() = _getURL


    private val _getLyrics = MutableLiveData<String>()
    val getLyrics: MutableLiveData<String> get() = _getLyrics

    fun getVideoURL() {
        job = CoroutineScope(Dispatchers.IO).async {
            repository.getSong(trackId).response.song.media.forEach {
                _getURL.postValue(
                    (if (it.provider == "youtube") {
                        it.url
                    } else {
                        "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
                    }).toString()
                )
            }
        }
    }

    fun getLyrics(url: String) {
        job = CoroutineScope(Dispatchers.IO).async {

            val execute = Jsoup.connect(url).execute()
            val document = Jsoup.parse(execute.body())

            val element = document.getElementsByClass("lyrics").get(0)

            val jsoupDoc = Jsoup.parse(element.toString())
            val outputSettings = Document.OutputSettings();
            outputSettings.prettyPrint(false);
            jsoupDoc.outputSettings(outputSettings);
            jsoupDoc.select("br").before("\n");
            jsoupDoc.select("p").before("\n");

            val lyrics = Jsoup.clean(jsoupDoc.html(), "", Whitelist.none(), outputSettings)
            _getLyrics.postValue(lyrics)
        }

    }


    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}