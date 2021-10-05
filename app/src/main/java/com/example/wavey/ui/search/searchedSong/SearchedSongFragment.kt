package com.example.wavey.ui.search.searchedSong

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.Observer
import com.example.wavey.R
import com.example.wavey.data.Track
import com.example.wavey.ui.favorites.FavoritesViewModel
import com.example.wavey.databinding.SearchedSongFragmentBinding
import com.example.wavey.repository.SongLyricsApi
import com.example.wavey.repository.SongRepository
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class SearchedSongFragment : Fragment() {

    companion object {
        fun newInstance() = SearchedSongFragment()
    }

    private lateinit var binding: SearchedSongFragmentBinding
    private lateinit var favoritesViewModel: FavoritesViewModel

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchedSongFragmentBinding.inflate(inflater, container, false)

        parentFragmentManager.setFragmentResultListener("songDetails",
            this,
            { _, result ->
                val trackId = result.get("trackId").toString()
                val url = result.get("trackURL").toString()
                val name = result.get("name").toString()
                var owner = result.get("owner").toString()
                owner = owner.subSequence(owner.indexOf("$name by ") + 1, owner.length) as String

                val repository = SongRepository(SongLyricsApi())
                val factory = SearchedSongModelFactory(repository, trackId)
                val searchedSongViewModel = ViewModelProvider(this, factory).get(
                    SearchedSongViewModel::class.java
                )

                searchedSongViewModel.getLyrics(url)
                binding.textDetails.setOnClickListener() {
                    searchedSongViewModel.getLyrics(url)
                }

                searchedSongViewModel.getLyrics.observe(viewLifecycleOwner, Observer { getLyrics ->
                    binding.textDetails.text = getLyrics.toString()
                })


                favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

                binding.saveLyrics.setOnClickListener {
                    val text = binding.textDetails.text
                    if (text != R.string.lyrics.toString()) {
                        insertDatatoDatabase(trackId, name, owner, text)
                    }
                }


                searchedSongViewModel.getVideoURL()
                searchedSongViewModel.getURL.observe(viewLifecycleOwner, Observer { getURL ->
                    val videoUrl = getURL.toString()

                    with(binding) {
                        thirdPartyPlayerView.getPlayerUiController().showFullscreenButton(true)
                        thirdPartyPlayerView.addYouTubePlayerListener(object :
                            AbstractYouTubePlayerListener() {
                            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                                val videoId =
                                    videoUrl.subSequence(videoUrl.indexOf("=") + 1, videoUrl.length)
                                youTubePlayer.cueVideo(videoId as String, 0f)
                            }
                        })

                    }
                })

            })

        return binding.root
    }

    private fun insertDatatoDatabase(
        trackId: String,
        name: String,
        owner: String,
        text: CharSequence
    ) {
        val track = Track(0, trackId.toInt(), name, owner, text as String)
        favoritesViewModel.addTrack(track)
        Toast.makeText(requireContext(), "Track added to Favorites", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding.thirdPartyPlayerView.release()
        Log.d("test", "SDOH")
    }

    override fun onStop() {
        super.onStop()
        binding.thirdPartyPlayerView.release()
        Log.d("test", "STOPPY")
    }

}