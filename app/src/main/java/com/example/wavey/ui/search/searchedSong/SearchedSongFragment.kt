package com.example.wavey.ui.search.searchedSong

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.lifecycle.Observer
import com.example.wavey.databinding.SearchedSongFragmentBinding
import com.example.wavey.repository.SongLyricsApi
import com.example.wavey.repository.SongRepository
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import org.jsoup.select.Elements
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchedSongFragment : Fragment() {


    companion object {
        fun newInstance() = SearchedSongFragment()
    }

    private lateinit var binding: SearchedSongFragmentBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchedSongFragmentBinding.inflate(inflater, container, false)

        parentFragmentManager.setFragmentResultListener("songDetails",
            this,
            { _, result ->
                val track = result.get("trackId").toString()
                val url = result.get("trackURL").toString()

                val repository = SongRepository(SongLyricsApi())
                val factory = SearchedSongModelFactory(repository, track)
                val searchedSongViewModel = ViewModelProvider(this, factory).get(
                    SearchedSongViewModel::class.java)

                searchedSongViewModel.getLyrics(url)

                searchedSongViewModel.getLyrics.observe(viewLifecycleOwner, Observer { getLyrics ->
                    binding.textDetails.text = getLyrics.toString()
                })


                searchedSongViewModel.getVideoURL()
                searchedSongViewModel.getURL.observe(viewLifecycleOwner, Observer { getURL ->
                    val videoUrl = getURL.toString()
                    Log.d("test",videoUrl)

                    with(binding){
                        thirdPartyPlayerView.getPlayerUiController().showFullscreenButton(true)
                        thirdPartyPlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                                val videoId = videoUrl.subSequence(videoUrl.indexOf("=")+1,videoUrl.length)
                                Log.d("test",videoId.toString())
                                youTubePlayer.cueVideo(videoId as String, 0f)
                            }
                        })

                    }
                })

                Log.d("test",track)
            })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.thirdPartyPlayerView.release()
        Log.d("test","SDOH")
    }

    override fun onStop() {
        super.onStop()
        binding.thirdPartyPlayerView.release()
        Log.d("test","STOPPY")
    }

}