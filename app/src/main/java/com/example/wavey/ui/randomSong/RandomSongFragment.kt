package com.example.wavey.ui.randomSong

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wavey.databinding.FavoritesSavedFragmentBinding
import com.example.wavey.databinding.FragmentRandomSongBinding
import com.example.wavey.repository.SongLyricsApi
import com.example.wavey.repository.SongRepository
import com.squareup.picasso.Picasso

class RandomSongFragment : Fragment() {

    private lateinit var randomSongViewModel: RandomSongViewModel
    private lateinit var binding: FragmentRandomSongBinding
    private var url: String? = null

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomSongBinding.inflate(inflater, container, false)

        val repository = SongRepository(SongLyricsApi())
        val factory = RandomSongModelFactory(repository,(0..7263410).random().toString())
        randomSongViewModel = ViewModelProvider(this, factory).get(
            RandomSongViewModel::class.java
        )


        randomSongViewModel.getData()
        randomSongViewModel.imageURL.observe(viewLifecycleOwner, Observer { imageUrl ->

            Log.d("test3", imageUrl.toString())
            Picasso.with(requireContext()).load(imageUrl).into(binding.imageView2)
        })

        randomSongViewModel.url.observe(viewLifecycleOwner, Observer { url ->
            repeat(12){
                randomSongViewModel.getLyrics(url.toString()) }

        randomSongViewModel.getLyrics.observe(viewLifecycleOwner, Observer { getLyrics ->
            binding.lyrics.text = getLyrics.toString()
        })

        })
//        randomSongViewModel.getLyrics.observe(viewLifecycleOwner)
//        searchedSongViewModel.
//        repeat(12) {
//            searchedSongViewModel.getLyrics(url)
//        }
//        binding.textDetails.setOnClickListener() {
//            searchedSongViewModel.getLyrics(url)
//        }
//
//        searchedSongViewModel.getLyrics.observe(viewLifecycleOwner, Observer { getLyrics ->
//            binding.textDetails.text = getLyrics.toString()
//        })
        return binding.root
    }

}