package com.example.wavey.ui.randomSong

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wavey.repository.SongRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist

class RandomSongViewModel(private val repository: SongRepository, private val trackId: String) :
    ViewModel() {

    private lateinit var job: Job
    private val _getLyrics = MutableLiveData<String>()
    val getLyrics: MutableLiveData<String> get() = _getLyrics

    private val _title = MutableLiveData<String>()
    val title: MutableLiveData<String> get() = _title

    private val _imageURL = MutableLiveData<String>()
    val imageURL: MutableLiveData<String> get() = _imageURL

    private val _owner = MutableLiveData<String>()
    val owner: MutableLiveData<String> get() = _owner

    private val _url = MutableLiveData<String>()
    val url: MutableLiveData<String> get() = _url

    fun getData(){
        job = CoroutineScope(Dispatchers.IO).async {
            val source = repository.getSong(trackId).response.song
            _title.postValue(source.title)
            _owner.postValue(source.fullTitle)
            _url.postValue(source.url)
            _imageURL.postValue(source.headerImageThumbnailUrl)
        }
    }

    fun getLyrics(url:String) {
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